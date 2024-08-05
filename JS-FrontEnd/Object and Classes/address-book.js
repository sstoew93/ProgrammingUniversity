function solve(input) {
    let addressBook = {};

    for (const entry of input) {
        let person = entry.split(':')[0];
        let address = entry.split(':')[1];

        addressBook[person] = address;
    }

    Object.keys(addressBook).sort().forEach(entry => {
        console.log(`${entry} -> ${addressBook[entry]}`);
    });

}

solve([
    "Tim:Doe Crossing",
    "Bill:Nelson Place",
    "Peter:Carlyle Ave",
    "Bill:Ornery Rd",
]);
