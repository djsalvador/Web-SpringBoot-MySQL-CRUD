document.querySelector('form').onsubmit = (e) =>{
    e.preventDefault()

    let email = "admin@gmail.com";
    let password = "admin";

    let inputEmail = document.querySelector('input[type="email"').value;
    let inputPass = document.querySelector('input[type="password"').value;

    if(inputEmail != email || inputPass != password){
        document.querySelector("#msg").innerHTML = "Login e/ou senha incorretos!"
    }

    if(inputEmail == email && inputPass == password){
      document.querySelector("#msg").innerHTML = "Você está sendo redirecionado", window.location.assign('/admin');
    }
  }