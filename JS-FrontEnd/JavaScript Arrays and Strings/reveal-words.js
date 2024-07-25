function reveal(word, text) {
    
    const sentence = text.split(' ');
    const words = word.split(', ');
    let output = '';

    for (let element = 0; element < sentence.length; element++) {
        if (sentence[element].startsWith('*')) {
            for (let word of words) {
                if (word.length === sentence[element].length) {
                    sentence[element] = word;
                }
            }
        }
        output += sentence[element] + ' ';
    }


    
    console.log(output);
}


reveal('great', 'softuni is ***** place for learning new programming languages');
reveal('great, learning', 'softuni is ***** place for ******** new programming languages');