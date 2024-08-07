function getPhonebook(input) {
    let phonebook = {};

    for (const entry of input) {
        let name = entry.split(" ")[0];
        let number = entry.split(" ")[1];
        phonebook[name] = number;
    }

    Object.keys(phonebook).forEach((entry) => {
        console.log(`${entry} -> ${phonebook[entry]}`);
    });
}

getPhonebook([
    "Tim 0834212554",
    "Peter 0877547887",
    "Bill 0896543112",
    "Tim 0876566344",
]);
