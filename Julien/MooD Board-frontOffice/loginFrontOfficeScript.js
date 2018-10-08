var baseUrlApi = 'http://localhost:8080';
//var baseUrlApi = 'http://localhost/phpmyadmin/db_structure.php?server=1&db=base+de+test&token=ba6c7cd5d0ab045d2960e2b43a938997';

// Create user
var submitElement = document.querySelector(
  'input[type=submit]'
);

submitElement.addEventListener('click',function(event){
  alert('Monsieur ? je suis le boutton je sais plus');
    event.preventDefault();
    var value = document.querySelector(
      'form.create-user>input[type=text]'
    ).value;
    // On va envoyer cette valeur au server
    var httpRequest = new XMLHttpRequest();
    httpRequest.open('POST', baseUrlApi+'/post/');
    httpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    httpRequest.send('name='+encodeURIComponent(value));
    httpRequest.onreadystatechange = function() {
      if (httpRequest.readyState === XMLHttpRequest.DONE) {
        if (httpRequest.status === 200) {
          var response = JSON.parse(httpRequest.responseText);
          afficherUser(response);
        } else {
          alert('Un problème est survenu avec la requête.');
        }
      }
    }
  }
);

function redir(element){
    document.location.href="LoginAdmin.html";
}