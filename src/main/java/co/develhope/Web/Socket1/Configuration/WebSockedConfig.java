
//creo classe dopo aver aggiunto dipendenze websocket al pom

package co.develhope.Web.Socket1.Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
//comunica a spring di abilitare i messaggi , poi implemento perchè ho bisogno di due metodi
public class WebSockedConfig implements WebSocketMessageBrokerConfigurer {

//canale comunicazione  tra client e server, cioè dove devono registrarsi per inviare messaggi
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/app");
    }
//qual'è l'endpoint dove si devono collegare i client per comunicare con server
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/gs-guide-websocket").withSockJS();
    }

}

//poi creo app.je e index.html