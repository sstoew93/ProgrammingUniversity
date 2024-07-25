function price(day, age) {

    const dayOfWeek = day;
    const ageOfPerson = age;
    let price = 0;

    if (dayOfWeek === 'Weekday') {
        if (age >= 0 && age <= 18) {
            price = 12;
        } else if (age > 18 && age <= 64) {
            price = 18;
        } else if (age > 64 && age <= 122) {
            price = 12;
        } else {
            price = -1;
        }
    } else if (dayOfWeek === 'Weekend') {
        if (age >= 0 && age <= 18) {
            price = 15;
        } else if (age > 18 && age <= 64) {
            price = 20;
        } else if (age > 64 && age <= 122) {
            price = 15;
        } else {
            price = -1;
        }
    } else {
        if (age >= 0 && age <= 18) {
            price = 5;
        } else if (age > 18 && age <= 64) {
            price = 12;
        } else if (age > 64 && age <= 122) {
            price = 10;
        } else {
            price = -1;
        }
    }

    if (price > 0) {
        console.log(`${price}$`);
    } else {
        console.log('Error!');
    }
}

price('Holiday', -12);