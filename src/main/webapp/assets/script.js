const $presents = document.querySelectorAll(".present");
const $absents = document.querySelectorAll(".absent");

$presents.forEach(($present) => {
    $present.addEventListener("click", async (e) => {
        const id = $present.classList[$present.classList.length - 1];
        await fetch(`attendance`, {
            method: "POST", headers: {
                'Content-Type': 'application/x-www-form-urlencoded',
            }, body: "id=" + id + "&isPresent=true"
        });
    });
})

$absents.forEach(($absent) => {
    $absent.addEventListener("click", async (e) => {
        const id = $absent.classList[$absent.classList.length - 1];
        await fetch(`attendance`, {
            method: "POST", headers: {
                'Content-Type': 'application/x-www-form-urlencoded',
            }, body: "id=" + id
        });
    });
});