const sign_in_btn = document.querySelector("#account-btn");
const sign_up_btn = document.querySelector("#users-btn");
const container = document.querySelector(".container");

sign_up_btn.addEventListener("click", () => {
    container.classList.add("users-mode");
});

sign_in_btn.addEventListener("click", () => {
    container.classList.remove("users-mode");
});