// fill in javascript code here
document.querySelector("form").addEventListener("submit", addDetails);

function addDetails(event) {
    event.preventDefault();
    let obj = {};

    let dName = document.querySelector("#name").value;
    obj.Name = dName;
    let ID = document.querySelector("#employeeID").value;
    obj.Id = ID;
    let Dept = document.querySelector("#department").value;
    obj.Dep = Dept;
    let ex = document.querySelector("#exp").value;
    obj.Exp = ex;
    let mail = document.querySelector("#email").value;
    obj.Email = mail;
    let mobile = document.querySelector("#mbl").value;
    obj.Mobile = mobile;

    displayTable(obj);
}

function displayTable(obj) {
    let row = document.createElement("tr");
    document.querySelector("tbody").append(row);

    let td1 = document.createElement("td");
    td1.innerText = obj.Name;
    let td2 = document.createElement("td");
    td2.innerText = obj.Id;
    let td3 = document.createElement("td");
    td3.innerText = obj.Dep;
    let td4 = document.createElement("td");
    td4.innerText = obj.Exp;
    let td5 = document.createElement("td");
    td5.innerText = obj.Email;
    let td6 = document.createElement("td");
    td6.innerText = obj.Mobile;
    let td7 = document.createElement("td");
    if (obj.Exp > 5) {
        td7.innerText = "Senior";
    }
    else if (obj.Exp >= 2 && obj.Exp <= 5) {
        td7.innerText = "Junior";
    }
    else if (obj.Exp <= 1) {
        td7.innerText = "Trainee";
    }
    let td8 = document.createElement("td");
    td8.innerText = "Delete";
    td8.style.backgroundColor = "red";

    row.append(td1, td2, td3, td4, td5, td6, td7, td8);
}