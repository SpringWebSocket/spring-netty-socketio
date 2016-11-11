package com.phearun.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.SpringAnnotationScanner;

@Configuration
public class SocketIOConfiguration {

	@Value("${socket.io.port}")  //inject value of property file
	private int port;
	
	@Value("${socket.io.host}")
	private String host;
	
	
	@Bean
	public SocketIOServer socketIOServer(){
		com.corundumstudio.socketio.Configuration config = new com.corundumstudio.socketio.Configuration();
	    config.setHostname(host);
	    config.setPort(port);
	    
	    SocketIOServer server = new SocketIOServer(config);	
		server.start();
		
		return server;
	}
	
	//For enable socket.io annotation ( @onConnect, @onEvent,...)
	@Bean
    public SpringAnnotationScanner springAnnotationScanner(SocketIOServer server) {
        return new SpringAnnotationScanner(server);
    }
	
}
