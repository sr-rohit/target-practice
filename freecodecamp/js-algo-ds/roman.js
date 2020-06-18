var conversionList = {
    "_1000": { value: 1000, symbol: 'M', linked: "_100" },
    "_500": { value: 500, symbol: 'D', linked: "_100" },
    "_100": { value: 100, symbol: 'C', linked: "_10" },
    "_50": { value: 50, symbol: 'L', linked: "_10" },
    "_10": { value: 10, symbol: 'X', linked: "_1" },
    "_5": { value: 5, symbol: 'V', linked: "_1" },
    "_1": { value: 1, symbol: 'I' }
};

function convertToRoman(num) {

    var quotient, i, linked, grp;
    var roman = "";
    for (var key in conversionList) {
        
        grp = conversionList[key];
        if (num >= grp.value) {
            quotient = Math.floor(num / grp.value);
            for (i = 0; i < quotient; i++) {
                roman += grp.symbol;
            }
            num = num % grp.value;
        }
        
        if (grp.linked) {
            linked = conversionList[grp.linked];
            if (num >= (grp.value - linked.value)) {
                roman = linked.symbol + grp.symbol;
                num -= (grp.value - linked.value);
            }
        }
    }
    return roman;
}

console.log(convertToRoman(4));