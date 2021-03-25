document.getElementById("login").addEventListener('click',function (event)
{
    if(document.getElementById('username').value == "" || document.getElementById('password').value ==""){
        alert("Molimo Vas, popunite sve podatke!");
        return;
    }
    var user = {
        username: document.getElementById('username').value,
        password: document.getElementById('password').value,
        }
    fetch('http://localhost:8080/salesystem/users', {
    method: 'post',
    headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
    },
    body: JSON.stringify(user)
    }).then(res => res.json())
    .then(res => 
        {
            if(res==true){
                document.getElementById('loginForm').style.display="none";
                document.getElementById('menu').style.display="block";
               // localStorage.setItem("salesystem-user", document.getElementById('username').value);
            }else{
                alert("Podaci nisu ispravni, pokusajte ponovo!");
            }
        }
    );
    event.preventDefault();
}  ); 

document.getElementById("logout").addEventListener('click',function (event){
    // localStorage.removeItem("salesystem-user");
    document.getElementById('menu').style.display="none";
   // document.getElementById('logout').style.visibility = 'hidden';
    document.getElementById('loginForm').style.display="block";      
})
