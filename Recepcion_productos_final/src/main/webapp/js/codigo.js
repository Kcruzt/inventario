/*En el codigo javascript, se hara una funcion auto-ejecutable, se esta enviando los objetos que estamos usando aunque sea
 * globables el document y el JSON y el window, y se harán las varibles para que trabajen
 * var url, es para el websocket en donde se va a conectar,Nuestro websocket tiene que conectarse por el protocolo
 ws, es decir que no lo haremos con https://, sino que nos conectamos por el protocolo ws.
 *La funcion se esta haciendo de uso estricta
 *De window, se va a encargar de traerme el localhost o tu dominio */
(function (window, document, JSON) {
    'use strict';

    var url = 'ws://' + window.location.host + '/Almacen_final-1/chat',
            ws = new WebSocket(url),// tambien nuestro websocket una nueva instancia, enviamos como parametro la url a donde se conecta
            mensajes = document.getElementById('conversacion'),// donde vamos a agregar todos los mensajes 
            boton = document.getElementById('btnEnviar'),//boton que ejecutara el envio del mensaje, dentro del mensaje se pone el nombre en relacion al index 
            nombre = document.getElementById('usuario'),
            mensaje = document.getElementById('mensaje');
    //El ws, se asignara cuando se dispare el evento onopen, onclose cuando se cierre,onmessage cuando reciba los mensajes
    ws.onopen = onOpen;
    ws.onclose = onClose;
    ws.onmessage = onMessage;
    boton.addEventListener('click', enviar);

    function onOpen() {      
const Toast = Swal.mixin({  
  toast: true,
  position: 'top-end',
  showConfirmButton: false,
  timer: 3000,
  timerProgressBar: true,
  didOpen: (toast) => {
    toast.addEventListener('mouseenter', Swal.stopTimer)
    toast.addEventListener('mouseleave', Swal.resumeTimer)
  }
})

Toast.fire({
  icon: 'success',
  title: 'conectado !'
})
    }

    function onClose() {
     
    }

    function enviar() {// se crea un objetojson msg se dará como propiedades el nombre y mensajes lo que esta esperando el manejador
        var msg = {//ya se creo el objeto json
            nombre: nombre.value,
            mensaje: mensaje.value
        };
        //Se toma el objeto ws  y se lo enviamos a nuestro manejador, como parametros json.stringify(msg), se le esta haciendo un casteo al string,
        //para que se le pueda enviar a nuestro websocket (ws), crea el objeto con la informacion que se necesita enviar  y se le envia al ws
        ws.send(JSON.stringify(msg));
        mensaje.value=""
    }
    //esta funcion se va encargar de manejar lo que recibe del servidor, necesitamos saber quien es el que envia la informacion por eso se pone evt 
    function onMessage(evt) {//se crea un objeto y lo vamos a convertir en JSON, de la inforamcion que trae este evento
        var obj = JSON.parse(evt.data),//y de este objeto vamos a tomar la informacion denombre y mensaje para mostrarlo en la caja  
        msg = ' <strong class="label-input100" style="color:black"> <i class="fas fa-user"></i>' + obj.nombre + '</strong>'+': ' + obj.mensaje;// esta cadena lo estamos metiendo dentro de la caja conversacion
        mensajes.innerHTML += '<br/>' + msg;
    }

})(window, document, JSON);

