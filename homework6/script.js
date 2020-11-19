window.addEventListener("DOMContentLoaded", function () {
        window.onmousemove = function (event) {
            polX = event.x
            polY = event.y
            console.log(polX, polY)
            left = document.querySelector('.left')
            right = document.querySelector('.right')
            document.querySelector('.pupil').style.backgroundColor = 'black'
            if (polY < document.body.offsetHeight/2) {
                left.style.bottom = 'unset'
                right.style.bottom = 'unset'
                left.style.top = 0.075 * (polY) + 'px'
                right.style.top = 0.075 * (polY) + 'px'
            }
            else {
                left.style.top= 'unset'
                right.style.top= 'unset'
                left.style.bottom = 0.075 * (polY) + 'px'
                right.style.bottom = 0.075 * (polY) + 'px'
            }
            left.style.left = 0.075 * (polX) + 'px'

            right.style.left = 0.075 * (polX) + 'px'


        }
        window.onmouseover = function (event) {
            if ('eyes-apple' in event.target) {
                pupils = document.getElementsByClassName('pupil')
                for (let i = 0; i < pupils.length ; i++) {
                    pupils[i].style.backgroundColor = 'red'
                }
            }
        }
    }
)