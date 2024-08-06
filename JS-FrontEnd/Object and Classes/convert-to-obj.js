function convert(json) {
    let object = JSON.parse(json);

    for (const key in object) {
        console.log(`${key}: ${object[key]}`);
    }
}

convert('{"name": "George", "age": 40, "town": "Sofia"}');