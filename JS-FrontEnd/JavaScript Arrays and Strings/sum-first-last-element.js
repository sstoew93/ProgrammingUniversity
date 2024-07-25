function sumElements(input) {

    const firstElement = input.shift();
    const secondElement = input.pop();
    console.log(firstElement + secondElement);
}

sumElements([20, 30, 40]);