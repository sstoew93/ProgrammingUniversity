function solve(char1, char2) {
    let chars = "";

    const start = Math.min(char1.charCodeAt(0), char2.charCodeAt(0));
    const end = Math.max(char1.charCodeAt(0), char2.charCodeAt(0));

    function getChars(start, end) {
        for (let char = start + 1; char < end; char++) {
            chars += String.fromCharCode(char) + " ";
        }
        return chars;
    }

    console.log(getChars(start, end).trim());
}

solve("a", "d");
solve("C", "#");
