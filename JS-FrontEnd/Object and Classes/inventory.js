function getInventory(input) {
    let heroes = [];

    input.forEach(heroInfo => {
        const infoTokens = heroInfo.split(' / ');
        const heroName = infoTokens[0];
        const heroLevel = infoTokens[1];
        const heroItems = infoTokens[2];

        heroes.push({
            heroName,
            heroLevel,
            heroItems,
        })
    });

    heroes.sort(function(a,b) {
        return a.heroLevel - b.heroLevel
    });

    heroes.forEach(hero => {
        console.log(`Hero: ${hero.heroName}`);
        console.log(`level => ${hero.heroLevel}`);
        console.log(`items => ${hero.heroItems}`);
    });

}

getInventory([
    'Isacc / 25 / Apple, GravityGun',
    'Derek / 12 / BarrelVest, DestructionSword',
    'Hes / 1 / Desolator, Sentinel, Antara'
    ]);