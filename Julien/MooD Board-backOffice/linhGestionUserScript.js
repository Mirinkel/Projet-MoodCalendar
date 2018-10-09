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

var url = "http://localhost:8080/MoodBoardMOCK/ws/backWS/getAll";
      
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
                   

            table.appendChild(line);        
    });
}

function deleteUser(event) {
    event.preventDefault();
    var httpRequest = new XMLHttpRequest();
    httpRequest.onreadystatechange = function() {
        if (httpRequest.readyState == XMLHttpRequest.DONE) {
          if (httpRequest.status == 204) {
            displayUsers();
          } else {
            alert('KO');
          }
          console.log(httpRequest.status);
        }
        console.log(httpRequest.readyState );
    }

    var idUser = event.target.parentNode.childNodes[0].textContent;
    document.getElementById("haha").innerHTML = idUser;

    var url = "http://localhost:8080/MoodBoardMOCK/ws/backWS/deleteUser/"+idUser;

    httpRequest.open("DELETE", url, true);
    httpRequest.send(null);    
}
