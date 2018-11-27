function checkCPF() {
	
	cpf = $("#input-cpf").val();
	window.location.href = "ControleCompra?type=cpf&cpf=" + cpf;
	//alert("CPF: " + cpf);
	//$.ajax({
	//	url: "http://localhost:8080/labsoft-site/ControleCompra?type=cpf&cpf=" + cpf,
	//	type: "GET",
	//	success: function(result) {
	//		alert(result);
	//		console.log(result);
	//	},
	//	error: function(error) {
	//		alert(error);
	//		console.log(error);
	//	}
	//});
}