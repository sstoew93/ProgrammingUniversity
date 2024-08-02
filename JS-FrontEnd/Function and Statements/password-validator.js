function solve(input) {

    let isValid = true;

    function checkLength(password) {
        if (password.length < 6 || password.length > 10) {
            console.log('Password must be between 6 and 10 characters');
            isValid = false;
        }
    
    }

    function checkAlphaNumeric(password) {
        if (/[^a-zA-Z0-9]/.test(password)) {
            console.log('Password must consist only of letters and digits');
            isValid = false;
        }

    }

    function checkDigits(password) {
        let digits = 0;
        for (let index = 0; index < password.length; index++) {
            if (password[index] >= 0 && password[index] <= 9) {
                digits++;
            }
        }
        
        if (digits < 2) {
            console.log('Password must have at least 2 digits');
            isValid = false;
        }

    }

    checkLength(input);
    checkAlphaNumeric(input);
    checkDigits(input);

    if (isValid) {
        console.log('Password is valid');
    }

}

solve('MyPass123');
solve('Pa$s$s');
solve('logIn');