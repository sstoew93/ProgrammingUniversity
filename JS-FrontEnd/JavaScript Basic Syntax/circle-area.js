function circleArea(input) {

    let result;
    
    if (typeof(input) === 'number') {
        const radius = input;
        result = Math.PI * radius ** 2;
    } else {
        console.log(`We can not calculate the circle area, because we receive a ${typeof(input)}.`);
        return;
    }

    console.log(result.toFixed(2));

}

circleArea(5);
circleArea('name');