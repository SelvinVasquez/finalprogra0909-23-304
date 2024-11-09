function mostrarVariables(){
    let variable1='texto de pruebas';
    let variable2 = 12345;
    let variable3 = 12345;
    let variable4 = 12345;
    let variable5 = 12345;
    let variableArray=["elemento1", "elemento2","elemento3","elemento4","elemento5",];
    console.log(variable1);
    console.log(variable2);
    console.log(variable3);
    console.log(variable4);
    console.log(variable5);
    console.log(variableArray);
    console.log(variableArray[1]);    
}

function concatenarVariables(var1, var2, var3, var4, var5){   
    let mensaje= var1+var2+var3+var4+var5;
    console.log(mensaje);
}

function mostrarObjetos(var1, var2){
    let orden_de_trabajo={"id_orden":var1, "fecha":var2, "cliente":var3, "total":var4, "observaciones":var5}
    console.log(orden_de_trabajo);
    console.log(orden_de_trabajo.id_orden);
}

function mostrarObjetosClasicos(){
    let alumno= new Object();
    alumno.id_orden='134685';
    alumno.fecha='10-5-2024';
    alumno.cliente='Jose Cayetano';
    alumno.total='5';
    alumno.observaciones='Le falto verificar autenticidad';
    metodoAnidadoQueMuestraPorConsola(orden_de_trabajo);
    eliminarPropiedadDeObjetos(orden_de_trabajo);
}

function metodoAnidadoQueMuestraPorConsola(unObjeto){
    console.log(unObjeto);
    console.log(unObjeto.nombre);
}

function eliminarPropiedadDeObjetos(objeto){
    delete objeto.correo;
    console.log(objeto);
}

function manipularElementosDelDom(){
    let orden_de_trabajo= new Object();
    let id_orden=document.getElementById("id_orden");
    let fecha=document.getElementById("fecha");
    let cliente=document.getElementById("cliente");
    let total=document.getElementById("total");
    let observaciones=document.getElementById("observaciones");
    orden_de_trabajo.id_orden=id_orden.value;
    orden_de_trabajo.fecha=fecha.value;
    orden_de_trabajo.cliente=cliente.value;
    orden_de_trabajo.total=total.value;
    orden_de_trabajo.observaciones=observaciones.value;
    console.log(orden_de_trabajo);
    id_orden.value='';
    fecha.value='';
    cliente.value='';
    total.value='';
    observaciones.value='';
}

function crearElementosEnEjecusion() {
	let divCreadoEnEjecusion = document.createElement('div');	
	let otroElemento = document.createElement('h4');
	let botones = document.createElement('button');
	otroElemento.append('El titulo deseado');
	divCreadoEnEjecusion.append("texto a agregar");
    botones.setAttribute("value", "Click Aqui");
	let container= document.getElementById("principal");
	container.append(otroElemento);
	container.append(divCreadoEnEjecusion);
	container.append(botones);
 	//console.log(divCreadoEnEjecusion); 		
}

function eliminarElementosEnEjecusion(){
	let container= document.getElementById("principal");
	container.remove();
}

function desestructurarArrays(){
	let miArray=['uno', 'dos','tres'];

	let [a, b, c]=miArray;

	console.log(a);
	console.log(b);
	console.log(c);
}

function manejoDeExcepciones(){
	try{
		algoQueNoExiste();
	}catch(error){
		console.log(error);
		console.error('Errores del try catch');
		console.error(error);
	}
	
}

function enviarFormulario(){
	let request = new XMLHttpRequest();
request.open('POST', 'NewServlet', true);
request.setRequestHeader('Content-Type', 'text/plain; charset=UTF-8');

request.onreadystatechange = function() {
  if (request.readyState == XMLHttpRequest.DONE) {
    // Peticion terminada.
    if (request.status == 200) {
      // Todo salio bien
      console.log(request.response);
    } else {
      console.log("Error en el envío " + request.response);
    }
  }
}

var formData = new FormData(document.getElementById('form'));
request.send(formData);
}

function enviarFormularioOpcion2(){
	const XHR = new XMLHttpRequest();
	  var formData = new URLSearchParams(new FormData(document.getElementById('form'))).toString();
         
	  // Define what happens in case of error
	  XHR.addEventListener('error', (event) => {
	    alert('Oops! Something went wrong.');
	  });

	  // Set up our request
	  XHR.open('POST', 'NewServlet', true);
          XHR.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
          
          XHR.onload = () => {
            if (XHR.readyState === XHR.DONE && XHR.status === 200) {
              console.log("response => " + XHR.response);
              //console.log("response xml=> " + XHR.responseXML);
              document.getElementById('bodyTable').innerHTML=XHR.response;
              mostrarMensaje('Orden guardado exitosamente');
              limpiarFormulario();
            }
          };   
          XHR.send(formData);         
}


function limpiarFormulario(){
    document.getElementById("id_orden").value='';
    document.getElementById("fecha").value='';
    document.getElementById("cliente").value='';
    document.getElementById("total").value='';
    document.getElementById("observaciones").value='';
}

function mostrarMensaje(mensaje){
  Swal.fire({
    icon: 'success',
    title: mensaje,
    showConfirmButton: false,
    timer: 1500
    })
}

function eliminarOrde_De_Trabajo(id_orden){
    const XHR = new XMLHttpRequest();
    var formData = new URLSearchParams(new FormData());

    // Define what happens in case of error
    XHR.addEventListener('error', (event) => {
      alert('Oops! Something went wrong.');
    });

    // Set up our request
    XHR.open('POST', 'NewServlet', true);
    XHR.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    XHR.onload = () => {
      if (XHR.readyState === XHR.DONE && XHR.status === 200) {
        console.log("response => " + XHR.response);
        mostrarMensaje('Estudiante Eliminado exitosamente');
        setTimeout( function() { window.location.reload() }, 2000 );
      }
    };        
    formData.append('id_orden', id_orden);
    formData.append('control', 'ELIMINAR');
    XHR.send(formData); 
    
}

function mostrarOrden_De_Trabajo(){
    var control = document.getElementById("control");
    control.value="mostrar";
    const XHR = new XMLHttpRequest();
	  var formData = new URLSearchParams(new FormData(document.getElementById('form'))).toString();
	  // Define what happens in case of error
	  XHR.addEventListener('error', (event) => {
	    alert('Oops! Something went wrong.');
	  });
	  // Set up our request
	  XHR.open('POST', 'NewServlet', true);
          XHR.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
          
          XHR.onload = () => {
            if (XHR.readyState === XHR.DONE && XHR.status === 200) {
              console.log("response => " + XHR.response);
              document.getElementById('bodyTable').innerHTML=XHR.response;
              mostrarMensaje('Ordenes mostrados exitosamente');
              limpiarFormulario();
            }
          };   
          XHR.send(formData); 
}

function limpiarTabla(){
   var tabla=document.getElementById('tabla1');
   var totalFilas = tabla.rows.length;   
   for (var i = totalFilas -1; i >0; i--){
       tabla.deleteRow(i);
   }
}

