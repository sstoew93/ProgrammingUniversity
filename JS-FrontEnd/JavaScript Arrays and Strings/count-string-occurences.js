function count(text, word) {
    
    let array = text.split(' ');
    let countStrings = 0;

    for (let string of array) {
        if (word === string) {
            countStrings++;
        }
    }

    console.log(countStrings);

}

count('This is a word and it also is a sentence', 'is');