    //fetch data for service info
    var serviceSelect = document.getElementById('service-dropdown');
    fetch("http://localhost:8080/salesystem/services")
    .then((resp) => resp.json())
    .then(function(data) {
        var values = data;
        for (const val of values) {
            var option = document.createElement("option");
            option.value = val.services_id;
            option.text = val.name;
            serviceSelect.appendChild(option);
          }
      })
    .catch(function(error) {
        console.log(error);
    });
    //to add invoice 
    document.getElementById("addInvoiceItem").addEventListener('click',function ()
    {
        //total amount needs to be calculated
        var invoice = {
            quantity: document.getElementById('quantity').text,
            discount: document.getElementById('discount').text,
            unitPrice: document.getElementById('unitPrice').text,
            PDVBase: document.getElementById('PDVBase').text,
            PDVAmount: document.getElementById('PDVAmount').text,
            totalAmount: document.getElementById('totalAmount').text,
            service_id: document.getElementById('service-dropdown').value,
            }
        fetch('http://localhost:8080/salesystem/invoice-items', {
        method: 'post',
        headers: {
            'Accept': 'application/json, text/plain, */*',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(invoice)
        }).then(res => res.json())
        .then(res => console.log(res));
    }  ); 
    
    document.getElementById('showInvoiceItemForm').addEventListener('click', function () {
        document.getElementById('unosFakture').style.display="block"; 
    })
