function solve(input) {
    const heroesCount = parseInt(input[0]);

    let heroes = {};

    // Initializing heroes with their superpowers and energy
    for (let hero = 1; hero <= heroesCount; hero++) {
        let [name, powers, energy] = input[hero].split("-");
        let superPowers = powers.split(",");

        energy = parseInt(energy);

        heroes[name] = {
            superPowers,
            energy,
        };
    }

    // Processing commands
    for (let line = heroesCount + 1; line < input.length; line++) {
        if (input[line] === "Evil Defeated!") {
            break;
        }

        let [command, superheroName, argument1, argument2] = input[line].split(" * ");

        if (command === "Use Power") {
            let superpower = argument1;
            let energyRequired = parseInt(argument2);

            let superhero = heroes[superheroName];

            if (superhero.superPowers.includes(superpower) && superhero.energy >= energyRequired) {
                superhero.energy -= energyRequired;
                console.log(`${superheroName} has used ${superpower} and now has ${superhero.energy} energy!`);
            } else {
                console.log(`${superheroName} is unable to use ${superpower} or lacks energy!`);
            }

        } else if (command === "Train") {
            let trainingEnergy = parseInt(argument1);
            let superhero = heroes[superheroName];

            if (superhero.energy >= 100) {
                console.log(`${superheroName} is already at full energy!`);
            } else {
                let energyGained = Math.min(trainingEnergy, 100 - superhero.energy);
                superhero.energy += energyGained;
                console.log(`${superheroName} has trained and gained ${energyGained} energy!`);
            }

        } else if (command === "Learn") {
            let newSuperpower = argument1;
            let superhero = heroes[superheroName];

            if (superhero.superPowers.includes(newSuperpower)) {
                console.log(`${superheroName} already knows ${newSuperpower}.`);
            } else {
                superhero.superPowers.push(newSuperpower);
                console.log(`${superheroName} has learned ${newSuperpower}!`);
            }
        }
    }

    // print all heros
    for (let hero in heroes) {
        console.log(`Superhero: ${hero}`);
        console.log(` - Superpowers: ${heroes[hero].superPowers.join(", ")}`);
        console.log(` - Energy: ${heroes[hero].energy}`);
    }
}

// Test case
solve([
    "3",
    "Iron Man-Repulsor Beams,Flight-80",
    "Thor-Lightning Strike,Hammer Throw-10",
    "Hulk-Super Strength-60",
    "Use Power * Iron Man * Flight * 30",
    "Train * Thor * 20",
    "Train * Hulk * 50",
    "Learn * Hulk * Thunderclap",
    "Use Power * Hulk * Thunderclap * 70",
    "Evil Defeated!",
]);

