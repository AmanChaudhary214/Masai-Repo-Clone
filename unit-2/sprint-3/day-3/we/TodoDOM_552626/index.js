document.querySelector("form").addEventListener("submit", myTodo);

function myTodo(event) {
    event.preventDefault()
    let taskName = document.querySelector("#task").value;
    let taskPriority = document.querySelector("#priority").value;

    displayTable(taskName, taskPriority)
}

function displayTable(taskName, taskPriority) {
    let row = document.createElement("tr");
    document.querySelector("tbody").append(row);

    let td1 = document.createElement("td");
    td1.innerText = taskName;
    let td2 = document.createElement("td");
    td2.innerText = taskPriority;
    if (taskPriority == "High") {
        td2.style.backgroundColor = "red";
    }
    else if (taskPriority == "Low") {
        td2.style.backgroundColor = "green";
    }
    let td3 = document.createElement("td");
    td3.innerText = "Add as Fav.";
    row.append(td1, td2, td3);
}