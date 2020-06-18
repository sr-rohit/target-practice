function rot13(str) {

    var decodedStr = "";
    var alpha = /[A-Z]/;
    var decode, min = 'A'.charCodeAt(0);

    for (var i = 0; i < str.length; i++) {
        if (str[i].match(alpha)) {

            decode = str.charCodeAt(i) - 13;
            if (decode < min) {
                decode += 26;
            }
            decodedStr += String.fromCharCode(decode);

        } else {
            decodedStr += str[i];
        }
    }

    return decodedStr;
}

console.log(rot13("SERR PBQR PNZC"));
