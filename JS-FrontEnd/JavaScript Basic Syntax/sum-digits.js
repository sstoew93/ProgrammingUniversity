function sumAll(input) {

    let string = input.toString();
    let sum = 0;

    for (let index = 0; index < string.length; index++) {
        
        sum += parseInt(string[index]);
        
    }

    console.log(sum);

}

sumAll(245678);
sumAll(97561);
sumAll(543);