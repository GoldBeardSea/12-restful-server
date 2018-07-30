const HOMEPAGE = "http://localhost:8080/songs";
const form = document.getElementById("edit-form");
const deleteButton = document.getElementById("deleteSong");

deleteButton.addEventListener("click", (ev) => {
    fetch(form.action, {
    method: "DELETE"
    }).then(() => {
    window.location = HOMEPAGE;
    });
    });

form.addEventListener("submit", (ev) => {
    ev.preventDefault();
console.log(ev.target.method, ev.target.action);

const inputs = ev.target.getElementsByTagName("input");
const name = inputs[0].value;
const artist = inputs[1].value;
const album = inputs[2].value;
const releaseYear = inputs[3].value;
const song = {name, artist, album, releaseYear};
const body = JSON.stringify(song);

fetch(ev.target.action, {
    method: ev.target.getAttribute("method"),
    body: body
}).then(() => {
    window.location = HOMEPAGE;
});
})