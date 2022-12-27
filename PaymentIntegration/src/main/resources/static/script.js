

//sending request to server
const paymentStart=()=>{
	console.log("PaymentStarted");
	let amount = $("#amount").val();
	console.log(amount);
	if(amount == "" || amount == null){
		alert("amount is required");
		return;
	}


//ajax request

$.ajax({
	
	url : "/create_order",
	data : JSON.stringify({amount:amount,info:'order_request'}),
	contentType : 'application/json',
	type : 'POST',
	datatype : 'json',
	success: function(response){
		console.log(response);
		if (JSON.parse(response).status == "created"){
			//open payment form
			
			let options = {
				key: 'rzp_test_qWKyx5bSK2NFxt',
				amount: JSON.parse(response).amount,
				currency: 'INR',
				name: 'Parul Dashboard',
				description: 'payment app',
				image: 'https://in.pinterest.com/pin/tree-isolated-on-white-backg-google-search--570620215291396735/',
				order_id: JSON.parse(response).id,
				
				handler:function(response){
					console.log(razorpay.payment_id)
					console.log(razorpay.order_id)
					console.log(razorpay.log(razorpay_signature))
					console/log("payment successfull!!")
				},
				
				"prefill": {
        		"name": "",
       			"email": "",
        		"contact": ""
    				},
    			"notes": {
        		"address": "Parul's API"
    				},
    			"theme": {
        		"color": "#3399cc"
    			}
				
			};
			
			var rzp1 = new Razorpay(options);
			rzp1.on('payment.failed', function (response){
			console.log(response.error.code);
			console.log(response.error.description);
			console.log(response.error.source);
			console.log(response.error.step);
			console.log(response.error.reason);
		    console.log(response.error.metadata.order_id);
			console.log(response.error.metadata.payment_id);
			alert("payment failed!!")
			});
			
			rzp1.open()
		}
		
		
	},
	error: function(error){
		console.log("error");
		alert("Something went wrong")
	},
	
	
	
});

};