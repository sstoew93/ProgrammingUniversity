function printWords(text) {
    
    const textArr = text.split(' ');
    let regex = /^#[a-zA-Z]+$/;

    for (let word = 0; word < textArr.length; word++) {
        const element = textArr[word];

        if (element.startsWith('#') && element.length > 1 && regex.test(element)) {
            console.log(element.replace('#', ''));
        }

    }

}

printWords('Nowadays everyone uses # to tag a #special word in #socialMedia');
printWords('The symbol # is known #variously in English-speaking #reg2ions as the #number sign');