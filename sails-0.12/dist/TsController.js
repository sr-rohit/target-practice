"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const util = require("util");
function index(req, res, next) {
    console.log('index() from TsController.ts');
    res.status(200).send('Hello from Typescript!');
}
exports.index = index;
function config(req, res, next) {
    console.log('config() from TsController.ts');
    res.status(200)
        .send('<h1>sails.config :</h1><pre>' + util.inspect(sails.config) + '<pre>');
}
exports.config = config;
function abc(request, response, next) {
    console.log("came here");
    return response.ok("Hello there");
}
exports.abc = abc;
