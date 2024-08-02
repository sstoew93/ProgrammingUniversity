function solve(input) {
    let loaded = `%`.repeat(input / 10);
    let remaining = ".".repeat(10 - loaded.length);

    if (input === 100) {
        console.log("100% Complete!");
        console.log("[%%%%%%%%%%]");
    } else {
        console.log(`${input}% [${loaded}${remaining}]`);
        console.log("Still loading...");
    }
}

solve(30);
solve(50);
solve(100);
