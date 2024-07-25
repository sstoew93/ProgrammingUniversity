function priceCalculator(countPeople, typeOfGroup, dayOfWeek) {
    
    let pricePerPerson = 0;
    let type;

    if (dayOfWeek === 'Friday') {
        switch (typeOfGroup) {
            case 'Students':
                pricePerPerson = 8.45;
                type = 'Students';
            break;
            case 'Business':
                pricePerPerson = 10.90;
                type = 'Business';
            break;
            case 'Regular':
                pricePerPerson = 15;
                type = 'Regular';
            break;
        }
    } else if (dayOfWeek === 'Saturday') {
        switch (typeOfGroup) {
            case 'Students':
                pricePerPerson = 9.80;
                type = 'Students';
            break;
            case 'Business':
                pricePerPerson = 15.60;
                type = 'Business';
            break;
            case 'Regular':
                 pricePerPerson = 20;
                 type = 'Regular';
            break;
        }
    } else if (dayOfWeek === 'Sunday') {
        switch (typeOfGroup) {
            case 'Students':
                pricePerPerson = 10.46;
                type = 'Students';
            break;
            case 'Business':
                pricePerPerson = 16;
                type = 'Business';
            break;
            case 'Regular':
                pricePerPerson = 22.50;
                type = 'Regular';
            break;
        }
    }

    let priceWithoutDiscount = pricePerPerson * countPeople;
    let finalPrice = 0;

    // DISCOUNTS
    if (type === 'Students') {
        if (countPeople >= 30) {
            finalPrice = priceWithoutDiscount * 0.85;
        } else {
            console.log(`Total price: ${priceWithoutDiscount.toFixed(2)}`);
            return;
        }
    } else if (type === 'Business') {
        if (countPeople >= 100) {
            finalPrice = priceWithoutDiscount - 10 * pricePerPerson;
        } else {
            console.log(`Total price: ${priceWithoutDiscount.toFixed(2)}`);
            return;
        }
    } else if (type === 'Regular') {
        if ( countPeople >= 10 && countPeople <= 20) {
            finalPrice = priceWithoutDiscount * 0.95
        } else {
            console.log(`Total price: ${priceWithoutDiscount.toFixed(2)}`);
            return;
        }
        
    }

    console.log(`Total price: ${finalPrice.toFixed(2)}`);

}


priceCalculator(30, "Students", "Sunday");
priceCalculator(40, "Regular", "Saturday");