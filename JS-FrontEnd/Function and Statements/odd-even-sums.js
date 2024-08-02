function solve(input) {
    let evens = 0;
    let odds = 0;

    function oddSum(element) {
        odds += element;
    }

    function evenSum(element) {
        evens += element;
    }

    const inputToString = input.toString();
    for (let index = 0; index < inputToString.length; index++) {
        let element = Number(inputToString[index]);

        if (element % 2 === 0) {
            evenSum(element);
        } else {
            oddSum(element);
        }
    }

    console.log(`Odd sum = ${odds}, Even sum = ${evens}`);

}

solve(3495892137259234);