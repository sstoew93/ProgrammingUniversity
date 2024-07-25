function printAndSum(num1, num2) {

    let numbers = '';
    let sum = 0;
    
    for (let number = num1; number <= num2; number++) {
        numbers += number + ' ';
        sum += number;
    }

    console.log(numbers);
    console.log(`Sum: ${sum}`);
}

printAndSum(5,10);
printAndSum(0,26);
printAndSum(50,60);