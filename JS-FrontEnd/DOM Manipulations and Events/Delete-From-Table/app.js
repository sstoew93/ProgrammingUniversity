function deleteByEmail() {
    const input = document.getElementsByTagName("input")[0];
    const emailList = Array.from(document.querySelectorAll("tbody tr td:nth-child(2"));

    let isFound = false;

    emailList.forEach((email) => {
        if (input.value === email.textContent) {
            email.parentElement.remove();
            isFound = true;
        } 
    });

    if (isFound) {
        document.getElementById("result").textContent = 'Deleted.';
    } else {
        document.getElementById("result").textContent = 'Not found.';
    }

    input.value = '';
}


// function deleteByEmail() {
//     const input = document.getElementsByName("input")[0];

//     const emailList = Array.from(document.querySelectorAll("tbody tr td:nth-child(2)"));

//     emailList.forEach((email) => {
//         if (input.value === email.textContent) {
//             email.parentElement.remove();
//             document.getElementById("result").textContent = "Deleted.";
//         } else {
//             document.getElementById("result").textContent = "Not found.";
//         }
//     });
// }
