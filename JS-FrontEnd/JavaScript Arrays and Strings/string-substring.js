function substring(word, string) {
    
    const text = string.toLowerCase().split(' ');
    let isPresent = true;

    if (!text.includes(word.toLowerCase())) {
        isPresent = false;
    }

    if (isPresent) {
        console.log(word.toLowerCase());
    } else {
        console.log(`${word.toLowerCase()} not found!`);
    }

}

substring('javAscript', ' is the JavaScript best programming language');
substring('python', 'JavaScript is the best programming language');
