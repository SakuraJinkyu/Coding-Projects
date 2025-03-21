// Email alert
function alertBox() {
    const emailForm = document.querySelector(".email")
    const confirmForm = document.querySelector(".confirm")

    if (emailForm != confirmForm) {
        alert("Your emails do not match. Please confirm before submitting.")
    }
};