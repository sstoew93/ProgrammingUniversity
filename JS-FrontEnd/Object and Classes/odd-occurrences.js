function getOdds(input) {
    let words = {};
    let output = '';

    const wordsList = input.toLowerCase().split(' ');

    wordsList.forEach(element => {
        words[element] = 0;
    });

    wordsList.forEach(word => {
        if (words.hasOwnProperty(word)) {
            words[word]++;
        }
    });

    Object.keys(words).forEach(element => {
        if (words[element] % 2 !== 0) {
            output += element + ' ';
        }
    });

    console.log(output.trim());
}

getOdds('Java C# Php PHP Java PhP 3 C# 3 1 5 C#');
