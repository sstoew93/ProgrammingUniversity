function checkSame(input) {
    
    const string = input.toString();
    let sum = 0;
    let isSame = true;

    for (let index = 0; index < string.length; index++) {
        sum += parseInt(string[index]);

        if (string[index] !== string[0]) {
            isSame = false;
        }
    }

    console.log(isSame);
    console.log(sum);

}

checkSame(2222222);
checkSame(1234);