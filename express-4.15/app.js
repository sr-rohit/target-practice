var express = require('express');
var app = express();

// app.all('/*', function(req, res, next) {
//
//   console.log(req);
//   console.log(res);
//   res.send("Hello there!!!");
//   next();
// });
//
// app.all('/*', function(req, res) {
//
//   res.sendStatus(404);
// });

var router = app.Router({
  caseSensitive: false,
  strict: false
});

app.listen(3000, function() {
  console.log("Server Started");
});
