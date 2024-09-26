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



