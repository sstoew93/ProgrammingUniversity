function solve(num1, num2) {
    // function factorial(number) {
    //     let result = 1;
    //     for (let digit = 2; digit <= number; digit++) {
    //         result *= digit;
    //     }

    //     return result;
    // }

    function factorial(number) {
        if (number <= 1) {
            return 1;
        } else {
            return number * factorial(number - 1);
        }
    }

    const factorial1 = factorial(num1);
    const factorial2 = factorial(num2);

    console.log((factorial1 / factorial2).toFixed(2));
}



solve(5, 2); // 60.00
solve(6, 2); // 360.00
solve(8, 6); // 56.00
