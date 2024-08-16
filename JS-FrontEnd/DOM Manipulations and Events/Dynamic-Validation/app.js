function validate() {
    let input = document.getElementById("email");

    const regex = /^[a-z0-9]+@[a-z0-9]+\.[a-z]+$/i;

    input.addEventListener("change", () => {
        if (!regex.test(input.value.toLowerCase())) {
            input.classList.add("error");
        }else {
            input.classList.remove("error");
        }
    });

    
}
