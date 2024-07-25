function print(input, n) {

    let result = [];
    
    for (let element = 0; element < input.length; element+= n) {

        result.push(input[element]);
    }

    return result;
}

print(['5', '20', '31', '4', '20'], 2);
print(['dsa','asd', 'test', 'tset'], 2);