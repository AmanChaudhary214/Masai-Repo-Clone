// Write all the JS Code related to Completed Page Here 
let completed = JSON.parse(localStorage.getItem("task-completed")) || [];

let favourites = JSON.parse(localStorage.getItem("task-favourites")) || [];

displayTable(completed);

function displayTable(completed) {
    document.querySelector("tbody").innerText="";
    for (let i = 0; i < completed.length; i++) {
        let row = document.createElement("tr");
        document.querySelector("tbody").append(row);

        let td1 = document.createElement("td");
        td1.innerText = completed[i].taskName;
        let td2 = document.createElement("td");
        td2.innerText = completed[i].taskType;
        let td3 = document.createElement("td");
        td3.innerText = completed[i].taskDate;
        let td4 = document.createElement("td");
        td4.innerText = completed[i].taskPriority;

        let td5 = document.createElement("td");
        td5.innerText = "Favourite";
        td5.addEventListener("click", function() {
            favourites.push(completed[i]);
            localStorage.setItem("task-favourites", JSON.stringify(favourites));
        })
        row.append(td1, td2, td3, td4, td5);
    }
}