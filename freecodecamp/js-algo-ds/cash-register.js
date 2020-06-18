function checkCashRegister(price, cash, cid) {

    var status = "OPEN",
        change = [],
        dueChange = cash - price;
    var currency = {},
        currChange, quotient, totalCash = 0.0;
    var currencyOrder = {
        "ONE HUNDRED": 100,
        "TWENTY": 20,
        "TEN": 10,
        "FIVE": 5,
        "ONE": 1,
        "QUARTER": 0.25,
        "DIME": 0.1,
        "NICKEL": 0.05,
        "PENNY": 0.01
    };

    for (var curr of cid) {
        currency[curr[0]] = curr[1];
        totalCash += curr[1];
    }

    if (totalCash == dueChange) {
        return {
            status: "CLOSED",
            change: cid
        };
    }

    for (var curr in currencyOrder) {
        if (currency[curr] > 0 && dueChange > currencyOrder[curr]) {

            if (dueChange > currency[curr]) {
                currChange = currency[curr];
                currency[curr] = 0;
            } else {
                quotient = Math.floor(dueChange / currencyOrder[curr]);
                currChange = currencyOrder[curr] * quotient;
            }

            dueChange -= currChange;
            dueChange = (Math.round(dueChange * 100) / 100).toFixed(2);
            change.push([curr, currChange]);
            if (dueChange == 0) {
                break;
            }
        }
    }

    if (dueChange > 0) {
        status = "INSUFFICIENT_FUNDS";
        change = [];
    }

    return {
        status: status,
        change: change
    };
}

console.log(checkCashRegister(19.5, 20, [
    ["PENNY", 0.5],
    ["NICKEL", 0],
    ["DIME", 0],
    ["QUARTER", 0],
    ["ONE", 0],
    ["FIVE", 0],
    ["TEN", 0],
    ["TWENTY", 0],
    ["ONE HUNDRED", 0]
]));
