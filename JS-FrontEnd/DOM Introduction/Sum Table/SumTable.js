function sumTable() {
    let products = document.getElementsByTagName('td');
    let total = document.getElementById('sum');
    let sum = 0;

    for (let index = 1; index < Array.from(products).length - 1; index+=2) {
        sum += Number(products[index].textContent);
    }

    document.getElementById('sum').textContent = sum;
}