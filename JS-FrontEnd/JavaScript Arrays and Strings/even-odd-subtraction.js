function subtraction(input) {
    
    let evenSum = 0;
    let oddSum = 0;

    for (let element = 0; element < input.length; element++) {
        
        if (input[element] % 2 === 0) {
            evenSum += input[element];
        } else {
            oddSum += input[element];
        }
    }

    console.log(evenSum - oddSum);

}

subtraction([1,2,3,4,5,6]);
subtraction([3,5,7,9]);