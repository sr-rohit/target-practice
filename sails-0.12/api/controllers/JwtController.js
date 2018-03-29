var jwt = require('jsonwebtoken');
var fs = require('fs');

module.exports = {
    generate: function(request, response) {
        
        var cert = fs.readFileSync(sails.config.security.privateKey);
        var certPub = fs.readFileSync(sails.config.security.publicKey);
        
        var data = {
        };

        var options = {
            algorithm: 'RS256',
            issuer: 'rohit',
            expiresIn: '1d',
            notBefore: '0s',
            audience: 'rohit'
        };

        var token = jwt.sign({foo:'bar'}, {key: cert, passphrase: 'rohit@agg'}, options);

        var decoded = jwt.verify(token, certPub, {algorithms: ['RS256'], issuer: 'rohit'});

        var result = {
            token : token,
            decoded: decoded
        }

        response.ok(result);
    }
}
