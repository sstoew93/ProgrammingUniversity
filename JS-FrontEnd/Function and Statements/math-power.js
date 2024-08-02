function mathPower(number, power) {
    let result = 1;
    function calculate(number, power) {
        //return number**power;
        for (let i = 0; i < power; i++) {
            result *= number;
        }
        return result;
    }

    console.log(calculate(number, power));
}

mathPower(2, 8);