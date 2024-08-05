function extract(content) {
    let output = [];
    const text = document.getElementById('content').textContent;

    let matches = text.match(/\([^()]*\)/g);

    for (let index = 0; index < matches.length; index++) {
        output.push(matches[index].slice(1,(matches[index].length - 1)));
    }

    return(output.join('; '));
    
}