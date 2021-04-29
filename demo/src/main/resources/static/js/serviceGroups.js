//add
document.getElementById("add-service-group").addEventListener('click',function (event){
    document.getElementById("add-service-group-window").style.visibility = "visible";
});

document.getElementById("add-service-group-button").addEventListener('click',function (event)
    {
        if(document.getElementById('name').value =="" || document.getElementById('pdv-category-dropdown').value == null){
            alert("Popunite sva polja!");
            return;
        }
        var serviceGroup = {
            name: document.getElementById('name').value,
            PDVCategory: {
                id: document.getElementById('pdv-category-dropdown').value
            },
            firm: { //? enterprise
                enterprise_id: localStorage.getItem("salesystem-enterprise")
            }
            }
        fetch('http://localhost:8080/salesystem/serviceGroups', {
        method: 'post',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(serviceGroup)
        }).then(res => res.json())
        .then(res => 
            document.getElementById("add-service-group-window").style.visibility = "hidden"
            );
        event.preventDefault();
    }  ); 



//delete
document.getElementById("delete-service-group").addEventListener('click',function (event){
        document.getElementById("delete-service-widnow").style.visibility = "visible";
    });
    
    document.getElementById("delete-service-group-button").addEventListener('click',function (event)
        {
            var serviceSelected = document.getElementById('delete-service-group-dropdown').value;
            fetch('http://localhost:8080/salesystem/serviceGroups/' + serviceSelected, {
            method: 'delete',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            }).then(res => res.json())
            .then(res => 
                document.getElementById("delete-service-group-window").style.visibility = "hidden"
                );
            event.preventDefault();
        }  ); 

//fill in the table
//fill in checkboxes
//edit 
    
