function sort(input) {

    let array = input.sort((a,b) => a.localeCompare(b));

    for (let name = 0; name < array.length; name++) {
        console.log(`${name + 1}.${array[name]}`);
    }
}

sort(["John", "Bob", "Christina", "Ema"]);