function split(input) {

    const regex = /(?=[A-Z])/g;
    
    let output = input.split(regex);

    console.log(output.join(', '));

}

split('SplitMeIfYouCanHaHaYouCantOrYouCan');