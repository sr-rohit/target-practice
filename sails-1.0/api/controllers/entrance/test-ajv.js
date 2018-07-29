var Ajv = require('ajv');

module.exports = function (request, response) {

  var ajv = new Ajv({
    validateSchema: false
  });

  ajv.addKeyword('isIn', {
    validate: function (schema, data) {
      console.log("isIn", schema, data);
      return schema.indexOf(data) !== -1;
    }
  });

  ajv.removeKeyword('required').addKeyword('required', {
    validate: function (schema, data) {
      console.log("Required", schema, data);
      return (typeof data === 'undefined') !== schema;
    }
  });

  schema = {
    type: 'object',
    properties: sails.models['user'].attributes
  };

  console.log(ajv.getKeyword('isIn'));
  console.log(schema.properties.emailAddress);

  var validate = ajv.compile(schema);

  data = {
    'emailAddress': 'rohit.aggarwal@chargepoint.com'
  };

  var valid = validate(data);
  console.log(valid, ajv.errors);

  data = {
    'emailAddress': 'rohit.hp007@gmail.com'
  };

  var valid = validate(data);
  console.log(valid, ajv.errors);

  return response.ok();
};
