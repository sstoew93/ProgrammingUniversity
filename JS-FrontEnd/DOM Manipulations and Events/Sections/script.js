function create(words) {
    let container = document.getElementById("content");

    

    for (let word = 0; word < words.length; word++) {
        let newDiv = document.createElement("div");
        let newP = document.createElement("p");
        newP.style.display = "none";

        newP.textContent = words[word];
        newDiv.appendChild(newP);
        container.appendChild(newDiv);

        newDiv.addEventListener("click", () => {
            newP.style.display = "inline";
        });

    }
}
