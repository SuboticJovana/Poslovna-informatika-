//get services
var serviceSelect = document.getElementById('service-dropdown');
var invoiceItems = [];

    fetch("http://localhost:8080/salesystem/servicess")
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
    // add invoice 
    document.getElementById("saveInvoice").addEventListener('click',function (event)
    {
    	//on save show all items(can be edited) and than add to db
        var invoice = {
            quantity: document.getElementById('quantity').value,
            discount: document.getElementById('discount').value,
            unitPrice: document.getElementById('unitPrice').value,
            pdvBase: document.getElementById('pdvBase').value,
            pdvAmount: document.getElementById('pdvAmount').value,
            totalAmount: document.getElementById('totalAmount').value, //total amount needs to be calculated
            service_id: document.getElementById('service-dropdown').value,
            }
        invoiceItems = [...invoiceItems,invoice]
        console.log(invoiceItems);
        document.getElementById('invoiceBlock').style.display="none";
        console.log('added!');
        fetch('http://localhost:8080/salesystem/invoiceItems', {
        method: 'post',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(invoiceItems)
        }).then(res => res.json())
        .then(res => console.log(res));
        event.preventDefault();
    }  ); 


    //visible form
    document.getElementById('showInvoiceItemForm').addEventListener('click', function (event) {
        document.getElementById('invoiceBlock').style.display="block";
        event.preventDefault();
    });

    //add another one 

document.getElementById("addInvoiceItem").addEventListener('click',function (event)
    {
        var invoice = {
            quantity: document.getElementById('quantity').value,
            discount: document.getElementById('discount').value,
            unitPrice: document.getElementById('unitPrice').value,
            PDVBase: document.getElementById('pdvBase').value,
            PDVAmount: document.getElementById('pdvAmount').value,
            totalAmount: document.getElementById('totalAmount').value, //total amount needs to be calculated
            service_id: document.getElementById('service-dropdown').value,
            }
        invoiceItems = [...invoiceItems,invoice]
        console.log(invoiceItems);
        document.getElementById('quantity').value=0;
         document.getElementById('discount').value=0;
         document.getElementById('unitPrice').value=0;
         document.getElementById('pdvBase').value=0;
         document.getElementById('pdvAmount').value=0;
         document.getElementById('totalAmount').value=0;//total amount needs to be calculated
    }  ); 
