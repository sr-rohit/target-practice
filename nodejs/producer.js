var amqplib = require('amqplib');

(async function() {

	var conn = await amqplib.connect("amqp://guest:guest@localhost:5672");
	var channel = await conn.createChannel();
	await channel.assertQueue("node-test");

	var i = 0;
	setInterval(async function () {
		i++;
		console.log("Publishing " + i);
		await channel.publish("", "node-test", Buffer.from(i + " Hello world!!!"));
	}, 100);

})();

