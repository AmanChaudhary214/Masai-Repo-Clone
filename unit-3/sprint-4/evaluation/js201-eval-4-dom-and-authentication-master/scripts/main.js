// --- do not touch  ↓↓↓↓↓↓↓↓↓↓↓↓ ----------
const baseServerURL = `http://localhost:${
  import.meta.env.REACT_APP_JSON_SERVER_PORT
}`;
// --- do not touch  ↑↑↑↑↑↑↑↑↑↑↑↑ ----------

const recipeIngredientURL = `${baseServerURL}/recipeIngredients`;
const employeeURL = `${baseServerURL}/employees`;
const userRegisterURL = `${baseServerURL}/user/register`;
const userLoginURL = `${baseServerURL}/user/login`;
let paginationWrapper = document.getElementById("pagination-wrapper");

let loginUserUsername = document.getElementById("login-user-username").value;
let loginUserPassword = document.getElementById("login-user-passowrd").value;

let loginUserButton = document.getElementById("login-user");
let getTodoButton = document.getElementById("fetch-todos");

let mainSection = document.getElementById("data-list-wrapper");
let notificationWrapper = document.getElementById("notifications-wrapper");

let userAuthToken = localStorage.getItem("localAccessToken") || null;
let userId = +localStorage.getItem("userId") || null;
const urlAllTodosOfUser = `${baseServerURL}/todos?userId=${userId}`;
const urlTodosBase = `${baseServerURL}/todos/`;

let users = [];

fetch(userLoginURL)
  .then((res) => res.json())
  .then((data) => {
      users = data;
      userData(data);
  })

  fetch(urlAllTodosOfUser)
  .then((res) => res.json())
  .then((data) => {
      users = data;
      userData(data);
  })

loginUserButton.addEventListener(submit, login())

getTodoButton.addEventListener(submit, getTodo())

function login (loginUserUsername, loginUserPassword) {
  data.forEach(function (elem) {
    if (elem.username == loginUserUsername && elem.password == loginUserPassword) {
      document.createElement("div")
      let message = document.createElement("h5");
      message.innerText = "hey"+ elem.username + "welcome back!";
      div.append(message);
    }
  })
}