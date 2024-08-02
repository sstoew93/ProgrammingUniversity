function stringRepeat(string, count) {
    function repeater(string, count) {

        // return string.repeat(count);

        let result = '';
        for (let index = 0; index < count; index++) {
            result+= string; 
        }

        return result;
    }

    console.log(repeater(string,count));
}

stringRepeat('bla', 3);