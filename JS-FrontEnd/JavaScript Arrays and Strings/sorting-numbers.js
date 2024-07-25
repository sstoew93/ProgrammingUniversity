function sortNumbers(input) {
    
    let arr = input.sort((a, b) => a - b);
    
    let result = [];
    let start = 0;
    let end = arr.length - 1;
    
    while (start <= end) {
        if (start === end) {
            result.push(arr[start]);
        } else {
            result.push(arr[start]);
            result.push(arr[end]);
        }
        start++;
        end--;
    }

    return result;
}

sortNumbers([1, 65, 3, 52, 48, 63, 31, -3, 18, 56]);