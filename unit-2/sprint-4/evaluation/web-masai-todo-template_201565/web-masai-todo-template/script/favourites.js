// Write all the JS Code related to Favourites Page Here 
let favourites = JSON.parse(localStorage.getItem("task-favourites")) || [];

displayTable(favourites);

function displayTable(favourites) {
    document.querySelector("tbody").innerText = "";
    for (let i = 0; i < favourites.length; i++) {
        let row = document.createElement("tr");
        document.querySelector("tbody").append(row);

        let td1 = document.createElement("td");
        td1.innerText = favourites[i].taskName;
        let td2 = document.createElement("td");
        td2.innerText = favourites[i].taskType;
        let td3 = document.createElement("td");
        td3.innerText = favourites[i].taskDate;
        let td4 = document.createElement("td");
        td4.innerText = favourites[i].taskPriority;

        row.append(td1, td2, td3, td4);
    }
}