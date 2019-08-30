var amqplib = require('amqplib');

(async function () {
	
	var conn = await amqplib.connect("amqp://guest:guest@localhost:5672");
	var channel = await conn.createChannel();
	await channel.assertQueue("node-test");
	channel.prefetch(1);
	
	channel.consume("node-test", function (msg) {
		
		if (msg != null) {
			setTimeout(function () {
				console.log(msg.content.toString());
				channel.ack(msg);
			}, 250);
		}
	});
	
})();
