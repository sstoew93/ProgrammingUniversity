function solve(json) {
    let terms = {};

    json.forEach(jsonString => {
        const element = JSON.parse(jsonString);
        const term = Object.keys(element)[0];
        const definition = element[term];
        
        terms[term] = definition;
    });

    let sortedKeys = Object.keys(terms).sort((a, b) => a.localeCompare(b));

    sortedKeys.forEach(key => {
        console.log(`Term: ${key} => Definition: ${terms[key]}`);
    });
}

solve([
    '{"Bus":"A hot drink made from the roasted and ground seeds (coffee beans) of a tropical shrub."}',
    '{"Bus":"A large motor vehicle carrying passengers by road, typically one serving the public on a fixed route and for a fare."}',
    '{"Boiler":"A fuel-burning apparatus or container for heating water."}',
    '{"Tape":"A narrow strip of material, typically used to hold or fasten something."}',
    '{"Microphone":"An instrument for converting sound waves into electrical energy variations which may then be amplified, transmitted, or recorded."}'
    ]);