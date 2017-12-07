module.exports = {


  friendlyName: 'Hello',


  description: 'Hello something.',


  inputs: {

  },


  fn: function (inputs, exits) {

    sails.log('Running custom shell script... (`hello`)');

    // All done.
    return exits.success();

  }


};

