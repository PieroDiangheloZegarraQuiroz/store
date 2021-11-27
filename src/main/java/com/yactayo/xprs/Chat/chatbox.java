package com.yactayo.xprs.Chat;

import com.yactayo.xprs.Objetos.Codificador;
import com.yactayo.xprs.Objetos.Decodificador;
import com.yactayo.xprs.Objetos.Mensaje;
import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@ServerEndpoint(value="/soporte", encoders = {Codificador.class},decoders = {Decodificador.class})
public class chatbox {

    private static final List<Session> online = new ArrayList<>();

    @OnOpen
    public void inicio_sesion(Session sesion){
        online.add(sesion);
    }

    @OnClose
    public void cerrar_sesion(Session sesion){
        online.remove(sesion);
    }

    @OnMessage
    public void mensaje(Mensaje mensaje) throws IOException, EncodeException {
        for(Session sesion : online){
            sesion.getBasicRemote().sendObject(mensaje);
        }
    }
}
