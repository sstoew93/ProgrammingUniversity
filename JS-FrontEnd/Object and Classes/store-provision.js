function provisions(stock, delivery) {
    let stockObject = {};
    
    for (let index = 0; index < stock.length; index+=2) {
        const product = stock[index];
        const quantity = Number(stock[index + 1]);
        stockObject[product] = quantity;
    }

    for (let index = 0; index < delivery.length; index+=2) {
        let product = delivery[index];
        let quantity = Number(delivery[index + 1]);
        
        if(stockObject.hasOwnProperty(product)) {
            stockObject[product] = stockObject[product] + quantity;
        } else {
            stockObject[product] = quantity;
        }
    }

    Object.keys(stockObject).forEach(product => {
        console.log(`${product} -> ${stockObject[product]}`);
    });

}

provisions([
    'Chips', '5', 'CocaCola', '9', 'Bananas', '14', 'Pasta', '4', 'Beer', '2'
    ],
    [
    'Flour', '44', 'Oil', '12', 'Pasta', '7', 'Tomatoes', '70', 'Bananas', '30'
    ]);