const $presents = document.querySelectorAll(".present");
const $absents = document.querySelectorAll(".absent");

$presents.forEach(($present) => {
    $present.addEventListener("click", (e) => {
        const id = $present.classList[$present.classList.length - 1];
        const $absent = document.querySelector(".absent" + id);
        const $attendance = document.querySelector("#attendance" + id);

        $present.setAttribute("disabled", "disabled");
        $absent.setAttribute("disabled", "disabled");
        fetch(`attendance`, {
            method: "POST", headers: {
                'Content-Type': 'application/x-www-form-urlencoded',
            }, body: "id=" + id + "&isPresent=true"
        }).then(res => {
            return res.json();
        }).then(data => {
            if (data.result === "success") {
                $attendance.removeChild($present);
                $attendance.removeChild($absent);
            }
        }).catch(e => {
            $present.removeAttribute("disabled");
            $absent.removeAttribute("disabled");
        });
    });
})

$absents.forEach(($absent) => {
    $absent.addEventListener("click", (e) => {
        const id = $absent.classList[$absent.classList.length - 1];
        const $present = document.querySelector(".present" + id);
        const $attendance = document.querySelector("#attendance" + id);

        $absent.setAttribute("disabled", "disabled");
        $present.setAttribute("disabled", "disabled");
        fetch(`attendance`, {
            method: "POST", headers: {
                'Content-Type': 'application/x-www-form-urlencoded',
            }, body: "id=" + id
        }).then(res => {
            return res.json();
        }).then(data => {
            if (data.result === "success") {
                $attendance.removeChild($absent);
                $attendance.removeChild($present);
            }
        }).catch(e => {
            $absent.removeAttribute("disabled");
            $present.removeAttribute("disabled");
        });
    });
});