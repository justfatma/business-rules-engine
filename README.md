# business-rules-engine

### http://localhost:8080/h2-console         Tables are in H2 in memory database.

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


## Business Rules
1. If the payment is for a physical product, a packing slip is generated for shipping. 
Whether the product is physical or not is kept in the PRODUCT_GROUP table. Packing slip record is created on PACKING_SLIP table after a successfull member order. 
Whenever desired **generatepackingslips** request is done and packing slips are generated into the local folder. 
To avoid duplication, packing slips are generated for only the records with IS_PRESSED column = false.  (PACKING_SLIP table)
IMPORTANT: **pathName** variable in GeneratingPackingSlip class should be changed to a local path.

2. If the payment is for a book, packing slip is duplicated for the royalty department.
For royalth department the file name format is **packingslip-orderid-ForRoyaltyDep.html**
For shipping the file name format is **packingslip-orderid-ForShipping.html**

3. A passive membership can be activated.

4. A standart membership can be upgrated to premium membership. Passive membership can not be upgrated.

5. After a membership activation or upgrading, an information email is sent to the member.
IMPORTANT: For email, **fromAddress** and **applicationSpecificPassword** in SendingEmail class should be changed.
Because these variables are private and won't work on another machine.

6. For some products the free first aid video must be added to the packing slip.
Information on whether a product requires a free first aid video is kept in the PRODUCT table NEED_FIRST_AID_VIDEO column.

7. For a physical product or a book, a commission payment is generated for the agent. 
Commission rate information is kept on PRODUCT table, AGENT_COMMISSION_RATE column. 
The amount to be paid to the agent of the ordered product is kept on ORDER_DETAIL table, AGENT_COMMISSION_AMOUNT column.
If commission rate information is zero (for example for Ebooks) for an ordered product, AGENT_COMMISSION_AMOUNT will be zero.
