var util = require('util');
var mysql = require('mysql');
var mongodb = require('mongodb');

var mysql_connection = mysql.createConnection({
    host: '172.31.254.70',
    user: 'coulomb',
    password: 'Var3theB3st!',
    database: 'coulomb'
});

var coulomb, ws_api_log;

var migrate = async function (callback) {
    
    mysql_connection.query = util.promisify(mysql_connection.query);

	var offset = 0;
	var limit = 5000;
	var events = [];
	var users = [];
	var companies = [];

	var query1 = "SELECT id, name FROM clb_task_list WHERE task_type = 'WEB_SERVICE'";
	var results1 = await mysql_connection.query(query1);

	for (let i = 0; i < results1.length; i++) {
		events[results1[i].id] = results1[i].name;
	}

	var query1 = "SELECT id, organization_id, name FROM clb_company";
	var results1 = await mysql_connection.query(query1);

	for (let i = 0; i < results1.length; i++) {
		companies[results1[i].id] = {
			organization_id: results1[i].organization_id,
			name: results1[i].name,
		};
	}

	do {

    		query1 = 'SELECT * FROM clb_ws_api_log LIMIT ' + offset + ',' + limit;
	    	results1 = await mysql_connection.query(query1);

		var api_logs = [];

		for (let i = 0; i < results1.length; i++) {

			var api_log = results1[i];
			api_log._id = api_log.id;
			api_log.api_event_name = events[api_log.api_event_id];
			api_log.company = companies[api_log.company_id];

			if (users[api_log.user_id] !== undefined) {
				api_log.user = users[api_log.user_id];
			} else {

				var query2 = 'SELECT id, first_name, middle_initial, last_name, user_type, account_no FROM clb_user WHERE id = ' + parseInt(api_log.user_id) + ' LIMIT 1';
				var results2 = await mysql_connection.query(query2);

				results2 = results2[0];
				users[api_log.user_id] = {
					name: {
						first: results2.first_name,
						middle: results2.middle_initial,
						last: results2.last_name
					},
					type: results2.user_type,
					account_no: results2.account_no
				};
				api_log.user = users[api_log.user_id];
			}

			delete api_log.id;

			api_logs.push(api_log);
		}

		await ws_api_log.insert(api_logs);
	        process.stdout.write(".");

		offset += limit;
		
	} while (results1.length == limit);
};

mongodb.MongoClient.connect('mongodb://localhost:30000/coulomb', async function (err, connection) {
    
    coulomb = connection.db('coulomb');
    ws_api_log = coulomb.collection('ws_api_log');
    mysql_connection.connect();
    
    console.log("Start Time = ", new Date());
    await migrate();
    
    mysql_connection.end();
    connection.close();

    console.log("End Time = ", new Date());
});

/* 

db.ws_api_log.createIndex({user_id: 1}, {background: 1, name: 'idx_clbwsal_uid'});
db.ws_api_log.createIndex({account_handle: 1}, {background: 1, name: 'idx_clbwsal_ah'});
db.ws_api_log.createIndex({company_id: 1}, {background: 1, name: 'idx_clbwsal_cid'});
db.ws_api_log.createIndex({called_date: 1, user_id: 1, api_event_id: 1}, {background: 1, name: 'idx_wsl_user_event_id'});

*/
