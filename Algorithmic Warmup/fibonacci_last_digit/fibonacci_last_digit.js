// by Alexander Nikolskiy

const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    terminal: false
});

process.stdin.setEncoding('utf8');
rl.on('line', readLine);

function readLine(line) {
    console.log(fib(parseInt(line, 10)));
    process.exit();
}

function fib(n) {
    let arr = [0, 1];
  
    if (n <= 2) return 1;
  
    for (let i = 2; i <= n; i++) {
      arr[i] = arr[i - 1]%10 + arr[i - 2]%10;
    }
    
    if (n < 229 ){
        return arr[n];
    }else {
        return arr[n] %10;
    }
  }

module.exports = fib;
