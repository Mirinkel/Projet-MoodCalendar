var httpRequest = new XMLHttpRequest();    
httpRequest.onreadystatechange = function() {
if (httpRequest.readyState == XMLHttpRequest.DONE) {
    if (httpRequest.status == 200) {
    var nomManagers = JSON.parse(httpRequest.responseText);        
    displayNomManagers(nomManagers)
    }else {
    alert('KO');
    }
    console.log(httpRequest.status);
    }
    console.log(httpRequest.readyState );
    }       

var url = "http://localhost:8080/MoodBoard/ws/backWS/displayNomManagers";

httpRequest.open("GET", url, true);      
httpRequest.send(null);   

var items = document.querySelector('form#formular>select#manager');
function displayNomManagers(nomManagers){   
    nomManagers.forEach(
        function(nomManager) {              
        event.preventDefault();      
        for(i= 0; i < nomManagers.length; i++){                  
            var item = document.createElement("option");
            item.textContent = nomManager;                 
        }      
        items.appendChild(item);     
    });   
}
function getUrlVars() {
    var vars = {};
    var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi, function(m,key,value) {
        vars[key] = value;
    });
    return vars;
}

document.getElementById("idUser").value = getUrlVars()["idUser"];
document.getElementById("login").value = getUrlVars()["login"];
document.getElementById("password").value = getUrlVars()["password"];
document.getElementById("nom").value = getUrlVars()["nom"];
document.getElementById("prenom").value = getUrlVars()["prenom"];
document.getElementById("email").value = getUrlVars()["email"];
document.getElementById("agence").value = getUrlVars()["agence"];
//document.getElementById("nomTeam").value = getUrlVars()["nomTeam"];


var modifyUserElement = document.querySelector(
    'form#modifyUser>input[type=submit]'    
  );
  

  
  modifyUserElement.addEventListener('click', modifyUser);  
  
  function modifyUser(event) {
    event.preventDefault();    
    var httpRequest = new XMLHttpRequest();    
    httpRequest.onreadystatechange = function() {
      if (httpRequest.readyState == XMLHttpRequest.DONE) {
        if (httpRequest.status == 204) {
        console.log('OK');
        } else {
        alert('KO');
        }
        console.log(httpRequest.status);
      }
      console.log(httpRequest.readyState );
    }
  
    var type = document.getElementById("type").value;
    var login = document.getElementById("login").value;
    var password = document.getElementById("password").value;
    var nom = document.getElementById("nom").value;
    var prenom = document.getElementById("prenom").value;
    var email = document.getElementById("email").value;
    var agence = document.getElementById("agence").value;
    var manager = document.getElementById("manager").value;
    var nomTeam = document.getElementById("nomTeam").value;
  
    var url = "http://localhost:8080/MoodBoard/ws/backWS/modifyUser";
    var params = "idUser="+idUser + "type="+type+"&login="+login+"&password="+password+"&nom="+nom+"&prenom="+prenom+"&email="+email+"&agence="+agence+"&manager="+manager+"&nomTeam="+nomTeam;
  
    httpRequest.open("PUT", url, true);
    httpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    httpRequest.send(params);
  }


