function solve() {
    const addButtons = Array.from(
        document.getElementsByClassName('add-product')
    );
    const checkoutButton = document.getElementsByClassName('checkout')[0];
    const cartTextarea = document.getElementsByTagName('textarea')[0];

    let cart = [];
    let totalPrice = 0;

    addButtons.forEach((button) => {
        button.addEventListener('click', function () {
            const productElement = button.closest('.product');
            const productName = productElement.querySelector('.product-title').textContent;
            const productPrice = parseFloat(productElement.querySelector('.product-line-price').textContent);

            let productInCart = cart.find(product => product.name === productName);

            if (!productInCart) {
                cart.push({ name: productName, price: productPrice });
                totalPrice += productPrice;
            } else {
                totalPrice += productPrice;
            }

            cartTextarea.value += `Added ${productName} for ${productPrice.toFixed(2)} to the cart.\n`;
        });
    });

    checkoutButton.addEventListener('click', result => {
      const products = cart.map(product => product.name);
      cartTextarea.value += `You bought ${products.join(', ')} for ${totalPrice.toFixed(2)}.`;
      
      checkoutButton.disabled = true;
      addButtons.forEach(btn => {
         btn.disabled = true;
      })
   
   });
    
}
