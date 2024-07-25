function extractSubstring(word ='', startIndex, count) {

    let result = '';

    result = word.substring(startIndex, startIndex + count);

    console.log(result);
}

extractSubstring('ASentence', 1, 8);
extractSubstring('SkipWord', 4, 7);