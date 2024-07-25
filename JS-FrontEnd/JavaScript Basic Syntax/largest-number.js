function largest(...args) {
    const input = [...args];
    console.log(`The largest number is ${Math.max(...input)}.`);
}

largest(-3, -5, -22.5);