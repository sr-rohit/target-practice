function telephoneCheck(str) {

    var phoneRegex = /^(1\ ?)?(\(\d{3}\)|\d{3})[\ \-]?\d{3}[\-\ ]?\d{4}$/;
    return str.match(phoneRegex) != null;
}

console.log(telephoneCheck("1(555)555-555"));
