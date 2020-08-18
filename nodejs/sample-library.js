module.exports = {

    friendlyName: 'sample-library',

    fn: async function(input, exits) {

        console.log(this);

        return exits.success(true);
    }
}