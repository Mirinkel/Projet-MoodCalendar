var httpRequest = new XMLHttpRequest();    
httpRequest.onreadystatechange = function() {
    if (httpRequest.readyState == XMLHttpRequest.DONE) {
        if (httpRequest.status == 200) {
        var users = JSON.parse(httpRequest.responseText); 
        display(users);
        }else {
            alert('KO');
        }};
    }


function getLogin(event) {
    alert('Monsieur ? je suis le boutton je sais plus');
    console.log("Youhou");
    event.preventDefault();

    var login = document.querySelector('div.container-fluid>div.row>input[type=text]').value;
    console.log(login);

    var password = document.querySelector('div.container-fluid>div.row>input[type=password]').value;
    password.type ="text";
    console.log(password); 
    //document.getElementById("password").innerHTML = password;  

    if((login !== "user" ) || (password !== "mots de pass" )) {
        alert("Login ou Mot de pass n'est pas correct!");
        document.location.href='loginFrontOffice.html';
    } else {
        document.location.href='MoodChoice.html';
    }
}



    function redir(element){
        document.location.href="LoginAdmin.html";
    }
    /*var submitLogin = document.querySelector('input[type=submit]');
    console.log(submitLogin);
    submitLogin.addEventListener('click', getLogin);*/