function editElement(reference, match, replacer) {
    const content = reference.textContent;
    const edited = content.replace(new RegExp(match, 'g'), replacer);

    reference.textContent = edited;
}