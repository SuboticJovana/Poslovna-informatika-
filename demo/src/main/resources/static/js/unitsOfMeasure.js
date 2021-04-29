//add
document.getElementById("add-unit").addEventListener('click',function (event){
    document.getElementById("add-unit-window").style.visibility = "visible";
});

document.getElementById("add-unit-button").addEventListener('click',function (event)
    {
        if(document.getElementById('name').value =="" || document.getElementById('short-name').value == ""){
            alert("Popunite sva polja!");
            return;
        }
        var unitOfMeasure = {
            name: document.getElementById('name').value,
            shortName: document.getElementById('short-name').value,
            }
        fetch('http://localhost:8080/salesystem/unitOfMeasures', {
        method: 'post',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(unitOfMeasure)
        }).then(res => res.json())
        .then(res => 
            document.getElementById("add-unit-window").style.visibility = "hidden"
            );
        event.preventDefault();
    }  ); 



//delete
document.getElementById("delete-unit").addEventListener('click',function (event){
        document.getElementById("delete-unit-widnow").style.visibility = "visible";
    });
    
    document.getElementById("delete-unit-button").addEventListener('click',function (event)
        {
            //find selected item from checkbox
            var unitSelected = document.getElementById('delete-unit-dropdown').value;
            fetch('http://localhost:8080/salesystem/unitOfMeasures/' + unitSelected, {
            method: 'delete',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            }).then(res => res.json())
            .then(res => 
                document.getElementById("delete-unit-window").style.visibility = "hidden"
                );
            event.preventDefault();
        }  ); 

//fill in the table

//edit 
    
