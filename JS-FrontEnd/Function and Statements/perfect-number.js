function solve(input) {
    let divisorsSum = 0;

    for (let digit = 1; digit < input; digit++) {
        if (input % digit === 0) {
            divisorsSum += digit;
        }
    }

    checkPerfectNumber(input,divisorsSum);

    function checkPerfectNumber(input, divisorsSum) {
        if (divisorsSum === input) {
            console.log("We have a perfect number!");
        } else {
            console.log("It's not so perfect.");
        }
    }
}

solve(6);
solve(28);
solve(1236498);
