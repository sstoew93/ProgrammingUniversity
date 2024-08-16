function lockedProfile() {
    const profiles = document.querySelectorAll(".profile");

    Array.from(profiles).forEach((profile) => {
        const button = profile.querySelector("button");
        const radio = profile.querySelector("input[type=radio][value=lock]");

        button.addEventListener("click", () => {
            const showMore = button.previousElementSibling;

            if (!radio.checked) {
                if (button.textContent === "Show more") {
                    showMore.style.display = "block";
                    button.textContent = "Hide it";
                } else {
                    showMore.style.display = "none";
                    button.textContent = "Show more";
                }
            }

        });

    });

}
