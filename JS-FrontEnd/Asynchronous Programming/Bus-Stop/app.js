function getInfo() {
    const baseURL = "http://localhost:3030/jsonstore/bus/businfo/";
    const checkBtn = document.getElementById("submit");
    const busesInfo = document.getElementById("buses");

    //1287, 1308, 1327 and 2334.

    checkBtn.addEventListener("click", async () => {
        
        const input = document.getElementById("stopId").value;

        document.getElementById("buses").innerHTML = "";
        document.getElementById("stopName").textContent = "";

        if (input !== "1287" && input !== "1308" && input !== "1327" && input !== "2334") {
            document.getElementById("stopName").textContent = "Error";
            return;
        }

        const response = await fetch(baseURL + input);
        const data = await response.json();

        document.getElementById("stopName").textContent = data["name"];

        for (const info of Object.entries(data["buses"])) {
            const newLi = document.createElement("li");
            newLi.textContent = `Bus ${info[0]} arrives in ${info[1]} minutes`;
            busesInfo.appendChild(newLi);
        }
    });

}

document.addEventListener("DOMContentLoaded", getInfo);
