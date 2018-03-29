var util = require('util');
var mysql = require('mysql');
var mongodb = require('mongodb');
var parsexml = require('xml2js').parseString;
parsexml = util.promisify(parsexml);

var mysql_connection = mysql.createConnection({
    host: '172.31.254.70',
    user: 'coulomb',
    password: 'Var3theB3st!',
    database: 'coulomb'
});

var coulomb, rest_api_log;

var migrate = async function (callback) {
    
    mysql_connection.query = util.promisify(mysql_connection.query);

	var offset = 0;
	var limit = 5000;
	var users = [];

	do {

    		query1 = 'SELECT * FROM clb_rest_api_log LIMIT ' + offset + ',' + limit;
	    	results1 = await mysql_connection.query(query1);

		var api_logs = [];

		for (let i = 0; i < results1.length; i++) {

			var api_log = results1[i];
			api_log._id = api_log.id;
			api_log.data = await parsexml(api_log.request, {explicitArray: false, explicitRoot: false});

			if (api_log.user_id != null) {
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
			}

			delete api_log.id;

			api_logs.push(api_log);
		}

		await rest_api_log.insert(api_logs);
	        process.stdout.write(".");

		offset += limit;
		
	} while (results1.length == limit);
};

mongodb.MongoClient.connect('mongodb://localhost:30000/coulomb', async function (err, connection) {
    
    coulomb = connection.db('coulomb');
    rest_api_log = coulomb.collection('rest_api_log');
    mysql_connection.connect();
    
    console.log("Start Time = ", new Date());
    await migrate();
    
    mysql_connection.end();
    connection.close();

    console.log("End Time = ", new Date());
});

/* 

db.rest_api_log.createIndex({}, {background: 1, name: ''});

*/
