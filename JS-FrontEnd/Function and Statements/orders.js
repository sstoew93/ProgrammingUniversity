function calculateOrder(type, quantity) {
    const types = {
        coffee: 1.5,
        water: 1,
        coke: 1.4,
        snacks: 2,
    }

    const price = quantity * types[type];

    console.log(price.toFixed(2));
}

calculateOrder('water', 5);