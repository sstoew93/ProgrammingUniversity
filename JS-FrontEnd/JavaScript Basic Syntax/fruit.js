function calculate(type, weightInGrams, priceForKg) {
    
    const weightInKg = weightInGrams / 1000;
    let neededMoney = weightInKg * priceForKg;

    console.log(`I need $${neededMoney.toFixed(2)} to buy ${weightInKg.toFixed(2)} kilograms ${type}.`);

}

calculate('orange', 2500, 1.80);
calculate('apple', 1563, 2.35);