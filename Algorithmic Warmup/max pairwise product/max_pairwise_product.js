// by Alexander Nikolskiy

const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    terminal: false
});

process.stdin.setEncoding('utf8');
rl.once('line', () => {
    rl.on('line', readLine);
});

function readLine (line) {
    const arr = line.toString().split(' ').map(Number);

    console.log(max(arr));
    process.exit();
}

function max(arr) {
    let num1 = 0;
    let num2 = 0;
    let ind1 =0;
    for (i = 0; i < arr.length; i++) {
        if (arr[i] > num1){
            num1 = arr[i];
            ind1 = i;
        }
      }

      for (j = 0; j < arr.length; j++) {
        if ((arr[j] > num2) && j != ind1){
            num2 = arr[j];
        }
      }
     return (num1*num2);
}



module.exports = max;
