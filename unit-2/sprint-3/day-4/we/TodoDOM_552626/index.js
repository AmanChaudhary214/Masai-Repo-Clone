document.querySelector("form").addEventListener("submit", myTodo);

let arr = JSON.parse(localStorage.getItem("todo")) || [];

let fav = JSON.parse(localStorage.getItem("fav")) || [];

function myTodo(event) {
    event.preventDefault()
    let taskName = document.querySelector("#task").value;
    let taskPriority = document.querySelector("#priority").value;

    let obj = {
        taskName,
        taskPriority
    };
    arr.push(obj);
    localStorage.setItem("todo", JSON.stringify(arr));

    displayTable(arr)
}

function displayTable(arr) {
    document.querySelector("tbody").innerHTML = "";
    for (let i = 0; i < arr.length; i++) {
        let row = document.createElement("tr");
        document.querySelector("tbody").append(row);

        let td1 = document.createElement("td");
        td1.innerText = arr[i].taskName;
        let td2 = document.createElement("td");
        td2.innerText = arr[i].taskPriority;
        if (arr[i].taskPriority == "High") {
            td2.style.backgroundColor = "red";
        }
        else if (arr[i].taskPriority == "Low") {
            td2.style.backgroundColor = "green";
        }
        let td3 = document.createElement("td");
        td3.innerText = "Add as Fav.";
        td3.addEventListener("click", function () {
            fav.push(arr[i]);
            localStorage.setItem("fav", JSON.stringify(fav));
        });
        row.append(td1, td2, td3);
    }
}