package com.sockets.appchat.controller;

import com.sockets.appchat.dto.ChatMessage;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    @MessageMapping("/chat/{roomId}") //El parametro el la room del cliente
    //Decimos que cuando llegue el mensaje se redireccione al
    //topic (El path se encuenta en WebSocketConfiguration) y tambien
    //agregamos la roomId
    @SendTo("/topic/{roomId}") //Tambien es el canal del envio de los mensajes.
    public ChatMessage chat(@DestinationVariable String roomId, ChatMessage message) {
        System.out.println(message.getMessage());
        return new ChatMessage(message.getMessage(), message.getUser());
    }

}
