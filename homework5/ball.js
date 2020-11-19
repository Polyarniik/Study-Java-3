window.addEventListener("DOMContentLoaded", function () {
    moveDown = true
    ball = document.getElementsByClassName('ball')[0]

    ball.onclick = function () {
        ball.style.backgroundColor = 'red'
        down = 0
        console.log(ball.getBoundingClientRect().top)
        console.log(document.documentElement.clientHeight)
        interval = setInterval(function () {
            down = moveDown ? down + 3 : down - 3
            if (moveDown && ball.getBoundingClientRect().top >= window.innerHeight - 100) {
                moveDown = false
            }
            if (!moveDown && ball.getBoundingClientRect().top <= 0) {
                moveDown = true
            }
            ball.style.top = down + 'px'
        }, 1)
    }

})
