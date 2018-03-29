var path = require('path');

module.exports.security = {

    privateKey: path.join(__dirname, 'cert', 'jwt.pem'),
    publicKey : path.join(__dirname, 'cert', 'jwt.pub')
}
