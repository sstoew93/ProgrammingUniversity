function charsToString(...args) {

    let string = '';

    for (let char = 0; char < args.length; char++) {
        string += args[char];
    }

    console.log(string);

}

charsToString('a', 'b', 'c');
charsToString('%', '2', 'o');