function solution() {
    const BASE_URL = "http://localhost:3030/jsonstore/advanced/articles/";
    const mainSection = document.getElementById("main");

    fetch(`${BASE_URL}list`)
        .then((response) => response.json())
        .then((data) => {
            data.forEach((article) => {
                const articleDiv = document.createElement("div");
                articleDiv.className = "accordion";

                const headDiv = document.createElement("div");
                headDiv.className = "head";
                const headSpan = document.createElement("span");
                headSpan.textContent = article.title;
                headDiv.appendChild(headSpan);

                const button = document.createElement("button");
                button.className = "button";
                button.textContent = "More";
                headDiv.appendChild(button);
                articleDiv.appendChild(headDiv);

                const extraDiv = document.createElement("div");
                extraDiv.className = "extra";
                extraDiv.style.display = "none"; // Initially hidden
                articleDiv.appendChild(extraDiv);

                button.addEventListener("click", () => {
                    if (button.textContent === "More") {
                        fetch(`${BASE_URL}details/${article._id}`)
                            .then((response) => response.json())
                            .then((data) => {
                                const contentP = document.createElement("p");
                                contentP.textContent = data.content;
                                extraDiv.innerHTML = ""; // Clear existing content
                                extraDiv.appendChild(contentP);
                            })
                            .catch((error) => console.error("Error fetching article details:", error));

                        extraDiv.style.display = "block";
                        button.textContent = "Less";
                    } else {
                        extraDiv.style.display = "none";
                        button.textContent = "More";
                    }
                });

                mainSection.appendChild(articleDiv);
            });
        })
        .catch((error) => console.error("Error fetching article list:", error));
}

solution();
