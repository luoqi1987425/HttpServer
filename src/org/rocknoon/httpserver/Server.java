package org.rocknoon.httpserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * 
 * @author rocky
 *
 */
public class Server {
	
	
	
	private static int SERVER_HEADER_SIZE = 1024;
	
	
	/**
	 * the server socket
	 */
	private ServerSocket _servSocket;
	
	/**
	 * env
	 */
	private String 	   _evn;
	
	
	
	
	
	
	
	
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
		
		char[] buf = new char[this.SERVER_HEADER_SIZE];
		BufferedReader in = new BufferedReader (new InputStreamReader(socket.getInputStream()));
		in.read( buf );
		
		//detect buf ending
		int length = 0;
		for( int i = 0; i < this.SERVER_HEADER_SIZE ; i ++ ){
			if( buf[i] == 0 ){
				length = i;
				break;
			}
		}
		
		
		String newString = new String(buf , 0 , length);
		
		HttpRequestBuilder.Build( buf );
	
	}

}
