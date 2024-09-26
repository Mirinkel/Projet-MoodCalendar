var httpRequest = new XMLHttpRequest();    
    httpRequest.onreadystatechange = function() {
    if (httpRequest.readyState == XMLHttpRequest.DONE) {
        if (httpRequest.status == 200) {
        var users = JSON.parse(httpRequest.responseText); 
        display(users);        
        }else {
        alert('KO');
        }
        console.log(httpRequest.status);
    }
    console.log(httpRequest.readyState );
    }       

var url = "http://localhost:8080/MoodBoard/ws/backWS/getAll";
  
httpRequest.open("GET", url, true);      
httpRequest.send(null);       


function display(users){   
    var table = document.querySelector('div.container>table.col-lg-12');    
        users.forEach(
            function(user) {                      
                var line = document.createElement("tr");  
                var tdIdUser = document.createElement("td");
                var tdPrenom = document.createElement("td"); 
                var tdNom = document.createElement("td");                    
                var tdEmail = document.createElement("td");
                var tdAgence = document.createElement("td");          
                var tdDelete = document.createElement('input');    
                var tdModify = document.createElement('input');            
                
                line.appendChild(tdIdUser);
                tdIdUser.textContent = user.idUser;  
                line.appendChild(tdPrenom);
                tdPrenom.textContent = user.prenom;    
                line.appendChild(tdNom);
                tdNom.textContent = user.nom;               
                line.appendChild(tdEmail);
                tdEmail.textContent = user.email;  
                line.appendChild(tdAgence);
                tdAgence.textContent = user.agence;   
                line.appendChild(tdDelete);   
                tdDelete.setAttribute('type', 'submit');
                tdDelete.setAttribute('value', 'X');
                tdDelete.addEventListener('click', deleteUser);
                line.appendChild(tdModify);   
                tdModify.setAttribute('type', 'submit');
                tdModify.setAttribute('value', 'M');
                tdModify.addEventListener('click', 
                function(event){
                    event.preventDefault();
                    url = "?idUser=" + user.idUser + "&type="+user.type+"&login="+user.login+"&password="+user.passWord+"&nom="+user.nom+"&prenom="+user.prenom+"&email="+user.email+"&agence="+user.agence;
                    window.location.href="modifyUser.html"+url;   
                })            
                table.appendChild(line);        
            });
        }

function deleteUser(event) {
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

    var idUser = event.target.parentNode.childNodes[0].textContent;      

    var url = "http://localhost:8080/MoodBoard/ws/backWS/deleteUser/"+idUser;

    httpRequest.open("DELETE", url, true);
    httpRequest.send(null);    
}

var createUserElement = document.querySelector(
    'form#formular>input[type=submit]'    
  );
  
  createUserElement.addEventListener('click', createUser);
  //createUserElement.addEventListener('click', sendEmail);
  
  function createUser(event) {
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
    var nomTeam = document.getElementById("agence").value;
  
    var url = "http://localhost:8080/MoodBoard/ws/backWS/createUser";
    var params = "type="+type+"&login="+login+"&password="+password+"&nom="+nom+"&prenom="+prenom+"&email="+email+"&agence="+agence+"&manager="+manager+"&nomTeam="+nomTeam;
  
    httpRequest.open("POST", url, true);
    httpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    httpRequest.send(params);
  }
  
 /* function sendEmail(event) {
    event.preventDefault();
    var email = document.getElementById("email").value;
    var subject = ("My permanent subject line");
    var body = ("My permanent body contents");
  
    var url = "mailto: "+email+"?subject=" +subject+"&body="+body;
    window.location.href = url;  
  }*/






  





