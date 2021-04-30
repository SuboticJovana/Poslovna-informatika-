//read
fetch("http://localhost:8080/salesystem/serviceGroups")
.then((resp) => resp.json())
.then(function(data) {
    var values = data;
    console.log(values);
    var table = document.getElementById("service-group-table");
    for (const val of values) {
        var newRow = document.createElement("tr");
        var td1 = document.createElement("td");
        var td2 = document.createElement("td");
        var td3 = document.createElement("td");
        td1.innerText= val.name;
        td2.innerText = val.PDVCategory.name;
        td3.innerText = val.firm.nameEnterprise;
        newRow.appendChild(td1);
        newRow.appendChild(td2);
        newRow.appendChild(td3);
        table.append(newRow);
      }
  })
.catch(function(error) {
    console.log(error);
});


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

document.getElementById("cancel-add").addEventListener('click',function (event){
    document.getElementById("add-service-group-window").style.visibility = "hidden";
});
    

//delete

var deleteGroupSelect = document.getElementById('delete-service-group-dropdown');
fetch("http://localhost:8080/salesystem/serviceGroups")
.then((resp) => resp.json())
.then(function(data) {
    var values = data;
    for (const val of values) {
        var option = document.createElement("option");
        option.value = val.id;
        option.text = val.name;
        deleteGroupSelect.appendChild(option);
      }
  })
.catch(function(error) {
    console.log(error);
});

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

document.getElementById("cancel-delete").addEventListener('click',function (event){
    document.getElementById("delete-service-group-window").style.visibility = "hidden";
});
        
//edit 
var editGroupSelect = document.getElementById('edit-service-group-dropdown');
fetch("http://localhost:8080/salesystem/serviceGroups")
.then((resp) => resp.json())
.then(function(data) {
    var values = data;
    for (const val of values) {
        var option = document.createElement("option");
        option.value = val.id;
        option.text = val.name;
        editGroupSelect.appendChild(option);
      }
  })
.catch(function(error) {
    console.log(error);
});

document.getElementById("edit-service-group").addEventListener('click',function (event){
    document.getElementById("edit-service-group-window").style.visibility = "visible";
});

document.getElementById("edit-service-group-button").addEventListener('click',function (event)
    {
        //find selected item from checkbox
        var groupSelected = document.getElementById('edit-service-group-dropdown').value;
        var serviceGroup = {
            name: document.getElementById('edit-name').value,
            PDVCategory: {
                id: document.getElementById('edit-pdv-category-dropdown').value
            }
            }
        fetch('http://localhost:8080/salesystem/serviceGroups/' + groupSelected, {
        method: 'put',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(serviceGroup)
        }).then(res => res.json())
        .then(res => 
            document.getElementById("edit-service-group-window").style.visibility = "hidden"
            );
        event.preventDefault();
    }  ); 

document.getElementById("cancel-edit").addEventListener('click',function (event){
    document.getElementById("edit-service-group-window").style.visibility = "hidden";
});


    
