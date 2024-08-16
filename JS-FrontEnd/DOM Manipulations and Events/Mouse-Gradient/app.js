function attachGradientEvents() {
    const gradient = document.getElementById('gradient');
    const result = document.querySelector('#result');

    gradient.addEventListener('mousemove', (e) => {
        const currentWidth = e.offsetX;
        const elementWidth = e.target.clientWidth;
        const progress = Math.floor((currentWidth / elementWidth) * 100);
        result.textContent = `${progress}%`;
    
    });

    gradient.addEventListener('mouseleave', () => {
        result.textContent = '';
    });
    
}