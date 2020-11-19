window.addEventListener('DOMContentLoaded', () => {
    colors = ['#808F85', '#91C499', '#F2E9DC'];
    ind = -1
    buttons = document.querySelectorAll(".btn");

    document.querySelector(".next-button").addEventListener('click', function () {
        ind = (ind + 1) % 3
        document.body.style.backgroundColor = colors[ind]
    })

    for (let i = 0; i < buttons.length; i++) {
        buttons[i].addEventListener('click', function () {
            document.body.style.backgroundColor = window.getComputedStyle(buttons[i]).backgroundColor;
            ind = i
        })
    }
})