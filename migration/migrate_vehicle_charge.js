var util = require('util');
var mysql = require('mysql');
var mongodb = require('mongodb');

var mysql_connection = mysql.createConnection({
    host: '172.31.254.70',
    user: 'coulomb',
    password: 'Var3theB3st!',
    database: 'coulomb'
});

var coulomb, vehicle_charge;

var migrate = async function (callback) {
    
    mysql_connection.query = util.promisify(mysql_connection.query);
    
    var query1 = 'SELECT DISTINCT(vehicle_charge_id) FROM clb_vehicle_charge_details';
    var results1 = await mysql_connection.query(query1);
    
    for (let i = 0; i < results1.length; i++) {
        
        var query2 = 'SELECT a.id AS vehicle_charge_id, a.*, b.* FROM clb_vehicle_charge a LEFT JOIN clb_vehicle_charge_ext b ON a.id = b.vc_id WHERE a.id = ' + parseInt(results1[i]['vehicle_charge_id']);
        var results2 = await mysql_connection.query(query2);
        if (results2.length == 0) {
            continue;
        }
        results2 = results2[0];
        
        var query3 = 'SELECT * FROM clb_vehicle_charge_details WHERE vehicle_charge_id = ' + parseInt(results1[i]['vehicle_charge_id']);
        var results3 = await mysql_connection.query(query3);
        
        results2.vehicle = {
            make: results2.vehicle_make,
            model: results2.vehicle_model,
            model_year: results2.vehicle_model_year
        };

        results2.address = {
            address1: results2.address1,
            address2: results2.address2,
            city: results2.city,
            state: results2.state,
            state_id: results2.state_id,
            country: results2.country,
            country_id: results2.country_id,
            county: results2.county_name,
            zipcode: results2.zipcode
        };

        results2.location = {
            "type": "Point",
            "coordinates": [results2.lon, results2.lat]
        };
        
        results2.details = results3;

        delete results2.id;
        delete results2.vc_id;
        delete results2.vehicle_make;
        delete results2.vehicle_model;
        delete results2.vehicle_model_year;
        delete results2.address1;
        delete results2.address2;
        delete results2.city;
        delete results2.state;
        delete results2.state_id;
        delete results2.country;
        delete results2.country_id;
        delete results2.county_name;
        delete results2.zipcode;
        delete results2.lon;
        delete results2.lat;
        
        await vehicle_charge.insertOne(results2);
        process.stdout.write(".");
    }
};

mongodb.MongoClient.connect('mongodb://localhost:30000/coulomb', async function (err, connection) {
    
    coulomb = connection.db('coulomb');
    vehicle_charge = coulomb.collection('vehicle_charge');
    mysql_connection.connect();
    
    console.log("Start Time = ", new Date());
    await migrate();
    
    mysql_connection.end();
    connection.close();
    console.log("End Time = ", new Date());
});

/* 

// Failed
db.vehicle_charge.createIndex({mac_address: 1, outlet_number: 1, session_id: 1, start_time_from_station: 1}, {background: true, unique: true, name: 'idx_unique_session_main'});

// Passed
db.vehicle_charge.createIndex({mac_address: 1, outlet_number: 1, session_id: 1, start_time_from_station: 1}, {background: true, name: 'idx_unique_session_main'});
db.vehicle_charge.createIndex({device_id: 1}, {background: true, name: 'idx_vc_device_id'});
db.vehicle_charge.createIndex({company_id: 1}, {background: true, name: 'idx_vc_company_id'});
db.vehicle_charge.createIndex({region_id: 1}, {background: true, name: 'region_id'});
db.vehicle_charge.createIndex({fleet_vehicle_id: 1}, {background: true, name: 'fleet_vehicle_id_idx'});
db.vehicle_charge.createIndex({user_id: 1}, {background: true, name: 'user_id_idx'});
db.vehicle_charge.createIndex({reservation_id: 1}, {background: true, name: 'reservation_id_idx'});
db.vehicle_charge.createIndex({mac_address: 1}, {background: true, name: 'mac_add_idx'});
db.vehicle_charge.createIndex({end_time: 1}, {background: true, name: 'idx_clbvc_endtime'});
db.vehicle_charge.createIndex({account_id: 1}, {background: true, name: 'idx_clbvc_acctid'});
db.vehicle_charge.createIndex({is_home: 1}, {background: true, name: 'idx_clbvc_ishome'});
db.vehicle_charge.createIndex({demo_flag: 1}, {background: true, name: 'idx_clbvc_demoflag'});
db.vehicle_charge.createIndex({serial_number: 1}, {background: true, name: 'idx_clbvc_serialNumber'});
db.vehicle_charge.createIndex({session_start_time: 1}, {background: true, name: 'idx_clbvc_sstime'});
db.vehicle_charge.createIndex({billing_time: 1}, {background: true, name: 'idx_clbvc_billing_time'});
db.vehicle_charge.createIndex({total_amount: 1}, {background: true, name: 'idx_clbvc_total_amt'});
db.vehicle_charge.createIndex({rfid: 1}, {background: true, name: 'rfid_idx'});
db.vehicle_charge.createIndex({connector_id: 1}, {background: true, name: 'idx_connector_id'});
db.vehicle_charge.createIndex({'vehicle.make': 1, 'vehicle.model': 1, 'vehicle.model_year': 1}, {background: true, name: 'idx_vehicle_details'});
db.vehicle_charge.createIndex({device_id: 1, billing_time: 1}, {background: true, name: 'idx_vc_device_id_billing_time'});
db.vehicle_charge.createIndex({start_time: 1, ghg_saving: 1}, {background: true, name: 'clbvc_idx_stime'});
db.vehicle_charge.createIndex({fleet_id: 1}, {background: true, name: 'fk_vc_ext_fleet_id'});
db.vehicle_charge.createIndex({ps_id: 1}, {background: true, name: 'fk_vehicle_charge_ext_ps_id'});
db.vehicle_charge.createIndex({sdge_processing_state: 1}, {background: true, name: 'idx_sdge_processing_state'});
db.vehicle_charge.createIndex({sdge_site_mode: 1}, {background: true, name: 'idx_sdge_facility_mode'});
db.vehicle_charge.createIndex({'details.station_time_index': 1}, {background: true, name: 'vehicle_id_index'});
db.vehicle_charge.createIndex({'details.peak_power': 1}, {background: true, name: 'peak_power_index'});
db.vehicle_charge.createIndex({'details.average_power': 1}, {background: true, name: 'average_power'});
db.vehicle_charge.createIndex({'details.energy': 1}, {background: true, name: 'energy_index'});

*/
