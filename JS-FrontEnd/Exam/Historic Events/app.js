window.addEventListener("load", solve);

function solve() {
    const eventName = document.getElementById("name");
    const eventTime = document.getElementById("time");
    const eventDescription = document.getElementById("description");

    const addBtn = document.getElementById("add-btn");

    addBtn.addEventListener("click", (btn) => {
        btn.preventDefault();
        if (!eventName.value || !eventTime.value || !eventDescription.value) {
            return;
        }

        const editBtn = document.createElement("button");
        editBtn.classList.add("edit-btn");
        editBtn.textContent = "Edit";
        const nextBtn = document.createElement("button");
        nextBtn.classList.add("next-btn");
        nextBtn.textContent = "Next";

        const btnContainer = document.createElement("div");
        btnContainer.classList.add("buttons");
        btnContainer.appendChild(editBtn);
        btnContainer.appendChild(nextBtn);

        const pName = document.createElement("p");
        pName.textContent = eventName.value;
        const pTime = document.createElement("p");
        pTime.textContent = eventTime.value;
        const pDescription = document.createElement("p");
        pDescription.textContent = eventDescription.value;

        const article = document.createElement("article");
        article.appendChild(pName);
        article.appendChild(pTime);
        article.appendChild(pDescription);

        const li = document.createElement("li");
        li.appendChild(article);
        li.appendChild(btnContainer);

        document.getElementById("preview-list").appendChild(li);

        eventName.value = "";
        eventTime.value = "";
        eventDescription.value = "";
        addBtn.disabled = true;

        editBtn.addEventListener("click", (e) => {
            e.preventDefault();

            eventName.value = pName.textContent;
            eventTime.value = pTime.textContent;
            eventDescription.value = pDescription.textContent;

            addBtn.disabled = false;

            li.remove();
        });

        nextBtn.addEventListener("click", (e) => {
            e.preventDefault();

            document.getElementById("archive-list").appendChild(li);

            editBtn.remove();
            nextBtn.remove();

            const archiveBtn = document.createElement("button");
            archiveBtn.textContent = "Archive";
            archiveBtn.classList.add("archive-btn");
            li.appendChild(archiveBtn);

            archiveBtn.addEventListener("click", (e) => {
                e.preventDefault();

                li.remove();
				addBtn.disabled = false;
            });
        });
    });
}
