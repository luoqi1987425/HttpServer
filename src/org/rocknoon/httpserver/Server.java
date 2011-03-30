package org.rocknoon.httpserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * 
 * @author rocky
 *
 */
public class Server {
	
	
	/**
	 * the server socket
	 */
	public static ServerSocket _servSocket;
	
	/**
	 * env
	 */
	public static String 	   evn;
	
	
	/**
	 * 
	 * @param port
	 * @param path
	 */
	public Server( int port , String path ){
		
		
	}
	
	/**
	 * Æô¶¯Server
	 */
	public void start(){
		
		//try start
		//listen
		_listen();
		
	}
	
	private void _listen(){
		
		
		while (true){
			
			//log
			Socket socket;
			
			
			try {
				socket = _servSocket.accept();
				
				//build http request
				HttpRequest request = this._buildHttpRequest(socket);
				
				//process http request
				HttpResponse response = HttpProcess.process(request);
				
				//response http reponse
				this._renderHttpResponse(response);
				
				
			} catch (IOException e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}
		
	private void _buildHttpRequest( Socket socket ){
	
		
	
	}

}
