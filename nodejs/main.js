// let whelk = require("whelk");
let machine = require('machine');
let sampleLibrary = require("./sample-library");

// whelk(sampleLibrary.bind({a : 1}));

let abc = machine(sampleLibrary);

(async function() {

    console.log(abc.getDef());
    console.log(require('util').inspect(abc.customize));
    abc = abc.bind({a: 1});
    // console.log(abc);
    await abc();
})();


