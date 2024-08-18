function match() {
    const baseURL = "http://localhost:3030/jsonstore/matches/";

    const loadMatchBtn = document.getElementById("load-matches");
    const addMatchBtn = document.getElementById("add-match");
    const editMatchBtn = document.getElementById("edit-match");

    async function loadMatch() {
        const response = await fetch(baseURL);
        const data = await response.json();

        document.getElementById("list").innerHTML = "";

        for (const [id, match] of Object.entries(data)) {
            const host = document.createElement("p");
            host.textContent = match.host;

            const score = document.createElement("p");
            score.textContent = match.score;

            const guest = document.createElement("p");
            guest.textContent = match.guest;

            const inputContainer = document.createElement("div");
            inputContainer.classList.add("info");

            inputContainer.appendChild(host);
            inputContainer.appendChild(score);
            inputContainer.appendChild(guest);

            const btnContainer = document.createElement("div");
            btnContainer.classList.add("btn-wrapper");

            const changeBtn = document.createElement("button");
            changeBtn.classList.add("change-btn");
            changeBtn.textContent = "Change";
            const deleteBtn = document.createElement("button");
            deleteBtn.classList.add("delete-btn");
            deleteBtn.textContent = "Delete";

            btnContainer.appendChild(changeBtn);
            btnContainer.appendChild(deleteBtn);

            const li = document.createElement("li");
            li.classList.add("match");

            li.appendChild(inputContainer);
            li.appendChild(btnContainer);

            document.getElementById("list").appendChild(li);

            editMatchBtn.disabled = true;


            changeBtn.addEventListener('click', async () => {
                addMatchBtn.disabled = true;
                editMatchBtn.disabled = false;
 
                document.getElementById("host").value = match.host;
                document.getElementById("score").value = match.score;
                document.getElementById("guest").value = match.guest;
 
                document.querySelector("#form form").setAttribute("matchID", match._id);
 
                await fetch(`${baseURL}${id}`, {
                    method: "PUT",
                    headers: {
                        "Content-Type": "application/json",
                    },
                    body: JSON.stringify({
                        host,
                        score,
                        guest,
                        _id: id,
                    }),
                });
            });

            deleteBtn.addEventListener("click", async () => {
                await fetch(`${baseURL}${match._id}`, {
                    method: "DELETE",
                });
                loadMatch();
            });
        }
    }

    async function addMatch() {
        const hostInput = document.getElementById('host').value; 
        const scoreInput = document.getElementById('score').value; 
        const guestInput = document.getElementById('guest').value; 
    
        await fetch(baseURL, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                host: hostInput,
                score: scoreInput,
                guest: guestInput,
            }),
        });
    
        loadMatch(); 
        clear();   
    }

    async function editMatch() {
        const id = document.querySelector("#form form").getAttribute("matchID");
        const host = document.getElementById("host").value;
        const score = document.getElementById("score").value;
        const guest = document.getElementById("guest").value;
 
        await fetch(`${baseURL}${id}`, {
            method: "PUT",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                host,
                score,
                guest,
                _id: id,
            }),
        });
 
        document.getElementById("add-match").disabled = false;
        document.getElementById("edit-match").disabled = true;

        clearInputs();
        await loadMeal();

        document.querySelector("#form form").removeAttribute("matchId");
    };
    

    function clear() {
        document.getElementById("host").value = '';
        document.getElementById("score").value = '';
        document.getElementById("guest").value = '';
    }
    

    loadMatchBtn.addEventListener("click", loadMatch);
    addMatchBtn.addEventListener("click", addMatch);
    editMatchBtn.addEventListener('click', editMatch);
}

match();
