function extractText() {
    let items = document.getElementsByTagName('li');
    let extracted = [];
    let area = document.getElementById('result');

    for (const li of Array.from(items)) {
        extracted.push(li.textContent);
    }

    area.textContent = extracted.join('\n');
}