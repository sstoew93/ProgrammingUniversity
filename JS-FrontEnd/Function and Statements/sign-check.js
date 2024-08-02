function checkSign(...args) {
    const array = args;
    let positive = 0;
    let negative = 0;

    for (let arg = 0; arg < array.length; arg++) {
        if (array[arg] < 0) {
            negative++;
        } else if (array[arg] > 0) {
            positive++;
        }
    }

    if (negative % 2 === 0) {
        console.log('Positive');
    } else {
        console.log('Negative');
    }
}

checkSign(5, 12, -15);
checkSign(-6, -12, 14);
checkSign(-1, -2, -3);
