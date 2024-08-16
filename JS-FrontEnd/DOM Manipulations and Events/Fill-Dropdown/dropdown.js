function addItem() {
    const inputText = document.getElementById("newItemText").value;
    const inputValue = document.getElementById("newItemValue").value;

    const dropDown = document.getElementById("menu");

    let newOption = document.createElement("option");
    newOption.textContent = inputText;
    newOption.value = inputValue;

    dropDown.appendChild(newOption);

    document.getElementById("newItemText").value = '';
    document.getElementById("newItemValue").value = '';
}
