// by Alexander Nikolskiy

const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    terminal: false
});

process.stdin.setEncoding('utf8');

rl.once('line', line => {
    const [itemsCount, knapsackCapacity] = line.toString().split(' ').map(Number);
    const values = [];
    const weights = [];
    let count = 0;

    rl.on('line', line => {
        const [v, w] = readLine(line);
        values.push(v);
        weights.push(w);

        if (++count >= itemsCount) {
            console.log(max(itemsCount, knapsackCapacity, values, weights));
            process.exit();
        }
    });
});

function readLine(line) {
    const v = parseInt(line.toString().split(' ')[0], 10);
    const w = parseInt(line.toString().split(' ')[1], 10);

    return [v, w];
}

function max(count, capacity, values, weights) {
    var maxDiv = 0.0;
    var changeableCapc = capacity;
    var changeableWei = 0.0;
    var lastValue = 0.0;
    var indexOfMax = 0.0;
    var changeableVal = 0.0;


    for (var i = 0;i < count; i++){
        maxDiv = 0;
        for (var n = 0;n<values.length;n++){
            if ((values[n] / weights[n]) > maxDiv){
                maxDiv = (values[n] / weights[n]);
                changeableWei = weights[n];
                changeableVal = values[n];
                indexOfMax = n;
            } 
         }
         values.splice(indexOfMax,1);
         weights.splice(indexOfMax,1);
         if ( changeableCapc != 0){
            if (changeableWei <= changeableCapc){
                lastValue += changeableVal;
                changeableCapc -= changeableWei;

            }else {
                lastValue += Math.abs(changeableCapc)*maxDiv;
                changeableCapc -= changeableCapc;
            }
        }else {
            return lastValue.toFixed(4);
        }
    }
    return lastValue.toFixed(4);
}

module.exports = max;
