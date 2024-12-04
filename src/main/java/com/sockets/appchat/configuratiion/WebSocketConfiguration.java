package com.sockets.appchat.configuratiion;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker //Nos permite configurar un Broker para la comunicación con los clientes.
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {

    //Este metodo nos permite habilitar broker para permiter la comunicacion entre los clientes y el
    //servidor.
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //Se habilita el broker y se especifica el path por el cual se ingresara al broker
        registry.enableSimpleBroker("/topic");

        //Establecemos un path de destino de los mensajes, por donde la aplicacion va a estar destinando
        //los mensajes.
        registry.setApplicationDestinationPrefixes("/app");
    }


    //Este metodo nos permite resgistrar los endpoints
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //Especificamos el path por el cual el frontend se conectara al servidor socket
        //En setAllowedOrigins decimos los clientes que se pueden conectarse a este endpoint
        //withSockJS decimo que la conexion va a hacer por una libreria de JS, que se utiliza en el frontend.
        registry.addEndpoint("/chat-socket").setAllowedOrigins("/http://localhost:4200").withSockJS();
    }

}
