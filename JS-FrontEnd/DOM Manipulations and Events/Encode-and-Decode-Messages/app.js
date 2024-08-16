function encodeAndDecodeMessages() {
    const buttons = document.getElementsByTagName("button");

    Array.from(buttons).forEach((btn) => {
        btn.addEventListener("click", () => {
            const textAreas = document.getElementsByTagName("textarea");
            const firstArea = textAreas[0].value;
            let result = "";

            if (btn.textContent.includes("Encode")) {
                // ENCODE
                for (let char = 0; char < firstArea.length; char++) {
                    result += String.fromCharCode(firstArea.charCodeAt(char) + 1);
                }

                textAreas[0].value = "";
                textAreas[1].value = result;
            } else {
                // DECODE
                const secondArea = textAreas[1].value;
                for (let char = 0; char < secondArea.length; char++) {
                    result += String.fromCharCode(secondArea.charCodeAt(char) - 1);
                }

                textAreas[1].value = result;
            }
        });
    });
}
