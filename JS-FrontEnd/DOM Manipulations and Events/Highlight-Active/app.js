function focused() {
    const sections = Array.from(document.querySelectorAll('input[type=text]'));

    sections.forEach(section => {

        section.addEventListener('focus', () => {
            section.parentElement.classList.add('focused');
            
        })
        
    });

    sections.forEach(section => {

        section.addEventListener('blur', () => {
            section.parentElement.classList.remove('focused');
            
        })
        
    });
}