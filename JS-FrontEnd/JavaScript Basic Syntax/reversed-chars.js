function charsToString(...args) {

    let string = '';

    for (let char = args.length - 1; char >= 0; char--) {
        string += args[char] + ' ';
    }

    console.log(string);

}

charsToString('A', 'B', 'C');
charsToString('&', 'L', '&');