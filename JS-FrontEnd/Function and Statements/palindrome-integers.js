function solve(input) {
    const inputArr = input;

    for (let arr = 0; arr < inputArr.length; arr++) {
        let element = inputArr[arr].toString();

        let reversed = element.split('').reverse().join('');

        if (element === reversed) {
            console.log('true');
        } else {
            console.log('false');
        }
        
        
    }
}

solve([123, 323, 421, 121]);
