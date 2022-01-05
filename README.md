# business-rules-engine

### http://localhost:8080/members            GET request, lists members

### http://localhost:8080/members/2          GET request, gets the member with id 2

### http://localhost:8080/activate/2         PUT request, activates the membership with id 2. Email is sent after successfull activation.
For email, **fromAddress** and **applicationSpecificPassword** in SendingEmail class should be changed.
Because these variables are private and won't work on another machine.
                                           
### http://localhost:8080/upgrade/2          PUT request, upgrade the membership with id 2. Email is sent after successfull upgrading.
For email, **fromAddress** and **applicationSpecificPassword** in SendingEmail class should be changed.
Because these variables are private and won't work on another machine.
                                           
### http://localhost:8080/orders             GET request, lists orders

### http://localhost:8080/orders/1           GET request, gets the order with id 1

### http://localhost:8080/order              POST request, add the order in the request body. Below is sample.
{
    "member": {
        "id": 7
    },
    "paymentMethod": "PAY_PAL",
    "orderDetails": [
        {
            "product": {
                "id": 3
            },
            "orderCount": 2
        },
        { 
            "product": {
                "id": 32
            },
            "orderCount": 1
        }
    ]
}

### http://localhost:8080/products		            GET request, lists products

### http://localhost:8080/products/16   		      GET request, gets the product with id 16

### http://localhost:8080/packingslips            GET request, lists packing slips

### http://localhost:8080/packingslips/4		      GET request, gets the packing slip with id 4

### http://localhost:8080/generatepackingslips 	  GET request, generate packing slips 
**pathName** variable in GeneratingPackingSlip class should be changed to a local path.
