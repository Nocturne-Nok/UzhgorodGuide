function showLoginForm() {
    document.getElementById("loginForm").classList.remove("hidden");
    document.getElementById("registrationForm").classList.add("hidden");
}

function showRegistrationForm() {
    document.getElementById("registrationForm").classList.remove("hidden");
    document.getElementById("loginForm").classList.add("hidden");
}

function login() {
    // Отримання даних для авторизації
    let email = document.getElementById("loginEmail").value;
    let username = document.getElementById("loginUsername").value;
    let lastname = document.getElementById("loginLastname").value;
    let firstname = document.getElementById("loginFirstname").value;
    let password = document.getElementById("loginPassword").value;

    // Отримання вхідних даних і виконання авторизації
    // Ваш код авторизації тут

    // Після успішної авторизації закриття WebApps
    TelegramWebApp.hide();
}

function register() {
    // Отримання даних для реєстрації
    let email = document.getElementById("registerEmail").value;
    let username = document.getElementById("registerUsername").value;
    let lastname = document.getElementById("registerLastname").value;
    let firstname = document.getElementById("registerFirstname").value;
    let password = document.getElementById("registerPassword").value;

    // Отримання вхідних даних і виконання реєстрації
    // Ваш код реєстрації тут

    // Після успішної реєстрації закриття WebApps
    TelegramWebApp.hide();
}
