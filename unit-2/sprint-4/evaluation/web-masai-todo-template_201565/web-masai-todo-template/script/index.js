// Write all the JS Code related to Home Page Here 
document.querySelector("form").addEventListener("submit", mysub);

let arr = JSON.parse(localStorage.getItem("tasks")) || [];

let completed = JSON.parse(localStorage.getItem("task-completed")) || [];

function mysub(event) {
    event.preventDefault()
    let taskName = document.querySelector("#name").value;
    let taskType = document.querySelector("#type").value;
    let taskDate = document.querySelector("#date").value;
    let taskPriority = document.querySelector("#priority").value;

    let tasks = {
        taskName,
        taskType,
        taskDate,
        taskPriority
    };

    arr.push(tasks);
    localStorage.setItem("tasks", JSON.stringify(arr));

    displayTable(arr);
}

function displayTable(arr) {
    document.querySelector("tbody").innerText="";
    for (let i = 0; i < arr.length; i++) {
        let row = document.createElement("tr");
        document.querySelector("tbody").append(row);

        let td1 = document.createElement("td");
        td1.innerText = arr[i].taskName;
        let td2 = document.createElement("td");
        td2.innerText = arr[i].taskType;
        let td3 = document.createElement("td");
        td3.innerText = arr[i].taskDate;
        let td4 = document.createElement("td");
        td4.innerText = arr[i].taskPriority;

        let td5 = document.createElement("td");
        td5.innerText = "Complete";
        td5.addEventListener("click", function() {
            completed.push(arr[i]);
            localStorage.setItem("task-completed", JSON.stringify(completed));
        })
        row.append(td1, td2, td3, td4, td5);
    }
}