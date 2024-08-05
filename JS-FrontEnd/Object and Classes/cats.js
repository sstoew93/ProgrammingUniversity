function cats(input) {
    class Cat {
        constructor(name, age) {
            this.name = name;
            this.age = age;
        }

        meow() {
            console.log(`${this.name}, age ${this.age} says Meow`);
        }
    }

    let catsCatalogue = [];

    for (const cat of input) {
        let catName = cat.split(" ")[0];
        let catAge = cat.split(" ")[1];

        catsCatalogue.push(new Cat(catName, catAge));
    }

    catsCatalogue.forEach((cat) => {
        cat.meow();
    });
}

cats(["Mellow 2", "Tom 5"]);
cats(["Candy 1", "Poppy 3", "Nyx 2"]);
