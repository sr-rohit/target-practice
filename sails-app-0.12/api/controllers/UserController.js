module.exports = {

  login: function (req, res) {

    return res.send("Hello User/Login");
  },
  find: function(req, res) {

    return res.send("Hello User/find");
  },
  findOne: function(req, res) {

    return res.send("Hello User/findOne");
  }
};
