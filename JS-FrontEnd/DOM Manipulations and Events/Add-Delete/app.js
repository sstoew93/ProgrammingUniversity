function addItem() {
    const input = document.getElementById('newItemText').value;

    const listItems = document.getElementById('items');
    const item = document.createElement('li');

    item.innerHTML = input + '<a href="#">[Delete]</a>';
    listItems.appendChild(item);

    const deleteBtn = document.querySelectorAll('#items li a');

    deleteBtn.forEach(btn => {
        btn.addEventListener('click', () => {
            btn.parentElement.remove();
        })
    })

    document.getElementById('newItemText').value = '';

}