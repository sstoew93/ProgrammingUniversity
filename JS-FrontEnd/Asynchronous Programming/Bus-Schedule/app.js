function solve() {
    let currentStop = {
        id: "depot",
        name: "",
    };
    let nextStop = "";

    const infoBox = document.querySelector(".info");
    const departBtn = document.getElementById("depart");
    const arriveBtn = document.getElementById("arrive");

    async function depart() {
        try {
            const response = await fetch(`http://localhost:3030/jsonstore/bus/schedule/${currentStop.id}`);
            if (!response.ok) {
                throw new Error("Failed to fetch data");
            }
            const data = await response.json();

            currentStop.name = data.name;
            nextStop = data.next;

            infoBox.textContent = `Next stop ${currentStop.name}`;
            departBtn.disabled = true;
            arriveBtn.disabled = false;
        } catch (error) {
            infoBox.textContent = "Error";
            departBtn.disabled = true;
            arriveBtn.disabled = true;
        }
    }

    async function arrive() {
        infoBox.textContent = `Arriving at ${currentStop.name}`;
        departBtn.disabled = false;
        arriveBtn.disabled = true;

        currentStop.id = nextStop;
    }

    return {
        depart,
        arrive,
    };
}

let result = solve();
