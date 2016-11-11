package com.phearun.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.OnConnect;

@Component
public class SocketMessageHandler {

	private SocketIOServer server;
	
	@Autowired
	public SocketMessageHandler(SocketIOServer server){
		this.server = server;
		
		/*this.server.addConnectListener(new ConnectListener() {
	        @Override
	        public void onConnect(SocketIOClient client) {
	        	System.out.println("Client connected!" + client);
	        }
	    });

	    this.server.addDisconnectListener(new DisconnectListener() {
	        @Override
	        public void onDisconnect(SocketIOClient client) {
	        	System.out.println("Client disconnected!" + client);
	        }
	    });*/
	}
	
	@OnConnect
	public void onConnect(SocketIOClient client){
		System.out.println("=>Client Connected! " + client);
		System.out.println("=>Connected Clients : " + server.getAllClients().size());
	}
	
}
