function convert(firstName, lastName, hairColor) {
    let object = {
        firstName,
        lastName,
        hairColor,
    }

    let json = JSON.stringify(object);

    console.log(json);


}

convert('George', 'Jones', 'Brown');