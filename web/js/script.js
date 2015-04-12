$(document).on("ready",function(){
	$('#ciudadBuscar').keyup(function() {
	  	$('.buscar').css('display','block');
	  	var busqueda = $("#ciudadBuscar").val();
	  	$.post("http://localhost:8090/ESY/procesarRegistroPersonaCiudades.do", { ciudadBuscar: busqueda })
		.done(function(data) {
		  	$('.buscar ul').html(data);
		})
		.fail(function(e) {
		    console.log(e);
	  	});
	});
	/*var valorNombres = 0;
	$( "#nombres" ).click(function() {
		//alert("Nombres Click");
		$.post("http://localhost:8080/ESY/procesarListadoPersonaOrd.do", { ordenar: "nombres", tipo: valorNombres })
		.done(function(data) {
		  	$('#tablecontent').html(data);
		  	console.log(" Entro al .done ");
		  	if(valorNombres==0) {
		  		valorNombres=1;
		  		console.log(" Primero "+valorNombres);
		  	} else {
		  		valorNombres=0;
		  		console.log(" Primero Else"+valorNombres);
		  	}
		  	console.log(" Saliendo del .done ");
		})
		.fail(function(e) {
		    console.log(e);
	  	});
	  	console.log(" Saliendo del .post ");
	});
	var valorApellidos = 0;
	$( "#apellidos" ).click(function() {
		$.post("http://localhost:8080/ESY/procesarListadoPersonaOrd.do", { ordenar: "apellidos", tipo: valorApellidos })
		.done(function(data) {
		  	$('#tablecontent').html(data);
		  	if(valorApellidos==0) {
		  		valorApellidos=1;
		  	} else {
		  		valorApellidos=0;
		  	}
		})
		.fail(function(e) {
		    console.log(e);
	  	});
	});
	var valorDireccion = 0;
	$( "#direccion" ).click(function() {
		$.post("http://localhost:8080/ESY/procesarListadoPersonaOrd.do", { ordenar: "direccion", tipo: valorDireccion })
		.done(function(data) {
			console.log(data);
		  	$('#tablecontent').html(data);
		  	if(valorDireccion==0) {
		  		valorDireccion=1;
		  	} else {
		  		valorDireccion=0;
		  	}
		})
		.fail(function(e) {
		    console.log(e);
	  	});
	});
	var valorTelefono = 0;
	$( "#telefono" ).click(function() {
		$.post("http://localhost:8080/ESY/procesarListadoPersonaOrd.do", { ordenar: "telefono", tipo: valorTelefono })
		.done(function(data) {
		  	$('#tablecontent').html(data);
		  	if(valorTelefono==0) {
		  		valorTelefono=1;
		  	} else {
		  		valorTelefono=0;
		  	}
		})
		.fail(function(e) {
		    console.log(e);
	  	});
	});
	var valorCiudad = 0;
	$( "#ciudad" ).click(function() {
		$.post("http://localhost:8080/ESY/procesarListadoPersonaOrd.do", { ordenar: "ciudad", tipo: valorCiudad })
		.done(function(data) {
		  	$('#tablecontent').html(data);
		  	if(valorCiudad==0) {
		  		valorCiudad=1;
		  	} else {
		  		valorCiudad=0;
		  	}
		})
		.fail(function(e) {
		    console.log(e);
	  	});
	});*/
});
//	 funcion de lista preguntas
 function listaPreguntas(){
 		var e = document.getElementById("seleccionaropcion");
 		var valor = e.options[e.selectedIndex].value;
 		//var valor=e.selectedIndex;
		$.post("http://localhost:8090/ESY/procesarListadoPregunta.do", { valor: valor})
		.done(function(data) {
		  	$('#seleccionaropcionpregunta').html(data);
		})
		.fail(function(e) {
		    console.log(e);
	  	});
	}

 //	 funcion de lista secciones
 function listaSecciones(){
 		var e = document.getElementById("seleccionar");
 		var valor = e.options[e.selectedIndex].value;
 		//var valor=e.selectedIndex;
		$.post("http://localhost:8090/ESY/procesarListadoSeccion.do", { valor: valor})
		.done(function(data) {
		  	$('#seleccionaropcion').html(data);
		})
		.fail(function(e) {
		    console.log(e);
	  	});
	}
 //  funciones para ordenar

 	//****ordenar por nombre***//
var valorNombres = 0;
function nombre(){
		$.post("http://localhost:8090/ESY/procesarListadoPersonaOrd.do", { ordenar: "nombres", tipo: valorNombres })
		.done(function(data) {
		  	$('#tablecontent').html(data);
		  	if(valorNombres==0) {
		  		valorNombres=1;
		  	} else {
		  		valorNombres=0;
		  	}
		})
		.fail(function(e) {
		    console.log(e);
	  	});
	}

// *** ordenar por apellido***//
var valorApellidos = 0;
	function apellido() {
		$.post("http://localhost:8090/ESY/procesarListadoPersonaOrd.do", { ordenar: "apellidos", tipo: valorApellidos })
		.done(function(data) {
		  	$('#tablecontent').html(data);
		  	if(valorApellidos==0) {
		  		valorApellidos=1;
		  	} else {
		  		valorApellidos=0;
		  	}
		})
		.fail(function(e) {
		    console.log(e);
	  	});
	}
	//*** ordenar por direccion***//
	var valorDireccion = 0;
	function direccion() {
		$.post("http://localhost:8090/ESY/procesarListadoPersonaOrd.do", { ordenar: "direccion", tipo: valorDireccion })
		.done(function(data) {
		  	$('#tablecontent').html(data);
		  	if(valorDireccion==0) {
		  		valorDireccion=1;
		  	} else {
		  		valorDireccion=0;
		  	}
		})
		.fail(function(e) {
		    console.log(e);
	  	});
	}
// *** ordenar por telefono ***//
	var valorTelefono = 0;
	function telefono(){
		$.post("http://localhost:8090/ESY/procesarListadoPersonaOrd.do", { ordenar: "telefono", tipo: valorTelefono })
		.done(function(data) {
		  	$('#tablecontent').html(data);
		  	if(valorTelefono==0) {
		  		valorTelefono=1;
		  	} else {
		  		valorTelefono=0;
		  	}
		})
		.fail(function(e) {
		    console.log(e);
	  	});
	}

	//*** ordenar por ciudad ***//
	var valorCiudad = 0;
	function ciudad() {
		$.post("http://localhost:8090/ESY/procesarListadoPersonaOrd.do", { ordenar: "ciudad", tipo: valorCiudad })
		.done(function(data) {
		  	$('#tablecontent').html(data);
		  	if(valorCiudad==0) {
		  		valorCiudad=1;
		  	} else {
		  		valorCiudad=0;
		  	}
		})
		.fail(function(e) {
		    console.log(e);
	  	});
	}

function seleccionarCiudad(id, ciudad, estado) {
	$('.buscar').css('display','none');
	$("#idCiudad").val(id);
	$("#ciudadBuscar").val(ciudad);
	$("#estadoNombre").html(estado);
}