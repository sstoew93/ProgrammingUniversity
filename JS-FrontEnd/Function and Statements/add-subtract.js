function solve(num1, num2, num3) {

    function sumDigits(num1, num2) {
        return num1 + num2;
    }

    let result = (num1, num2) => {
        return sumDigits(num1, num2) - num3;
    }

    console.log(result(num1,num2));


}

solve(23, 6, 10);
