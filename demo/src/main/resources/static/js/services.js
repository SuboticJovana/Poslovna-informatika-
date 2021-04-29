//add
document.getElementById("add-service").addEventListener('click',function (event){
    document.getElementById("add-service-window").style.visibility = "visible";
});

document.getElementById("add-service-button").addEventListener('click',function (event)
    {
        if(document.getElementById('name').value =="" || document.getElementById('description').value == ""
        || document.getElementById('goods').value =="" || document.getElementById('service-group-dropdown').value == null || 
        document.getElementById('unit-dropdown').value == null ){
            alert("Popunite sva polja!");
            return;
        }
        var service = {
            name: document.getElementById('name').value,
            description: document.getElementById('description').value,
            goods: document.getElementById('goods').value,
            serviceGroup: {
                id: document.getElementById('service-group-dropdown').value
            },
            unitOfMeasure: {
                id: document.getElementById('unit-dropdown').value
            }
            }
        fetch('http://localhost:8080/salesystem/services', {
        method: 'post',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(service)
        }).then(res => res.json())
        .then(res => 
            document.getElementById("add-service-window").style.visibility = "hidden"
            );
        event.preventDefault();
    }  ); 

//delete
document.getElementById("delete-service").addEventListener('click',function (event){
        document.getElementById("delete-service-widnow").style.visibility = "visible";
    });
    
    document.getElementById("delete-service-button").addEventListener('click',function (event)
        {
            var serviceSelected = document.getElementById('delete-service-dropdown').value;
            fetch('http://localhost:8080/salesystem/services/' + serviceSelected, {
            method: 'delete',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            }).then(res => res.json())
            .then(res => 
                document.getElementById("delete-service-window").style.visibility = "hidden"
                );
            event.preventDefault();
        }  ); 

//fill in the table
//fill in checkbox
//edit 
    
