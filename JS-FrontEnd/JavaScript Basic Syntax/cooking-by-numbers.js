function solve(number, ...args) {

    let result = number;
    let operators = args;


    for (let operator = 0; operator < args.length; operator++) {

        if (args[operator] === 'chop') {
            result = result / 2;
        } else if (args[operator] === 'dice') {
            result = Math.sqrt(result);
        } else if (args[operator] === 'spice') {
            result = result + 1;
        } else if (args[operator] === 'bake') {
            result = result * 3;
        } else if (args[operator] === 'fillet') {
            result = result * 0.8;
        } 

        console.log(result);
    }

}


solve('32', 'chop', 'chop', 'chop', 'chop', 'chop');
solve('9', 'dice', 'spice', 'chop', 'bake', 'fillet');