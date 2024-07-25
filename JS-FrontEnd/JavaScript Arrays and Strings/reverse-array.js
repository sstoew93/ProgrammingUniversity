function reverseArr(countElements, input) {

    let fullArr = input;
    let result = [];
    
    for (let element = 0; element < countElements; element++) {
        const current = fullArr[element];
        
        result.push(current);
    }

    result.reverse();
    console.log(result.join(' '));

}

reverseArr(3, [10, 20, 30, 40, 50]);