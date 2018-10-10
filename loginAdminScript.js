var submitLoginAdmin = document.querySelector('input[type=submit]');

submitLoginAdmin.addEventListener('click', getLoginAdmin);

function getLoginAdmin(event) {
    event.preventDefault(); 
    console.log("haha");
    var login = document.querySelector('div.container-fluid>div.row>input[type=text]').value;
    console.log(login);
    document.getElementById("login").innerHTML = login;
    var password = document.querySelector('div.container-fluid>div.row>input[type=password]').value;
        password.type ="text";
    
    console.log(password);    
    document.getElementById("password").innerHTML = password;  

    if((login !== "Administrateur" ) || (password !== "Mots de pass" )) {
        alert("Login ou Mot de pass n'est pas correct!");
        window.location.href='loginAdmin.html';
    } else {
        window.location.href='gestionUser.html';
    }

}