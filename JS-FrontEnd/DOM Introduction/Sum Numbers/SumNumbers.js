function calc() {
    const num1 = document.getElementById('num1');
    const num2 = document.getElementById('num2');

    const num1Value = num1.value
    const num2Value = num2.value;

    let sum = Number(num1Value) + Number(num2Value);

    document.getElementById('sum').value = sum;
}
