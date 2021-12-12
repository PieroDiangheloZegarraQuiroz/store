(function (window, document,JSON){
    var url='ws://'+window.location.host+'/xprs/soporte',
        ws = new WebSocket(url),
        mensajes = document.getElementById('conversacion'),
        boton = document.getElementById('btnEnviar'),
        nombre = document.getElementById('user'),
        mensaje = document.getElementById('mensaje');

    ws.onopen = onOpen;
    ws.onclose = onClose;
    ws.onmessage = onMessage;
    boton.addEventListener("click",enviar)

    function onOpen(){
        console.log('Un usuario se ha conectado')
    }

    function onClose(){
        console.log('Un usuario se ha desconectado');
        alert('Un usuario se Ha desconectado');
    }

    function enviar(){
        var msg = {
            nombre: user.value,
            mensaje: mensaje.value
        };

        ws.send(JSON.stringify(msg));
    }

    function onMessage(evt){
        let d = new Date();
        var obj = JSON.parse(evt.data),
            msg = '<div class="fecha"> Fecha: '+d.getUTCDate()+'/'+(d.getUTCMonth()+1)+'/'+d.getUTCFullYear()+'</div>'+'<li class="lichat">'+'<strong>'+obj.nombre+'</strong>'+ ' dice: '+'<br/>'+obj.mensaje+'</li>'+'<p class="text-muted" style="float: right;font-size: 12px;color: rgba(0,0,0,0.7)">'+'a las: '+d.getHours()+':'+d.getMinutes()+':'+d.getSeconds()+'</p>';
        mensajes.innerHTML += '<br/>'+msg;
    }
})(window, document, JSON);

function popupToggle(){
    const popup = document.getElementById('chat-content');
    popup.classList.toggle('popup');
}