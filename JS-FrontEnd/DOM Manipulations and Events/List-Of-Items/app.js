function addItem() {
    const newItem = document.getElementById("newItemText");
    
    const listItem = document.createElement("li");

    listItem.textContent = newItem.value;

    document.getElementById('items').appendChild(listItem);

    newItem.value = '';
}

