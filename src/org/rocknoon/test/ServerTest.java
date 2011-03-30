package org.rocknoon.test;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		
		try {
			
			ServerSocket ss = new ServerSocket(8081);
			char[] buf = new char[1024];
			
			while (true){
				
				
				System.out.println( "Server Start" );
				
				Socket socket = ss.accept();
				System.out.println( "Server accpet" );
				BufferedReader  in = new BufferedReader (new InputStreamReader(socket.getInputStream()));
				PrintWriter     out= new PrintWriter(socket.getOutputStream(),true);
				
				
				
				in.read( buf );
				
				String response = "";  
			    response += "HTTP/1.1 200 OK\n";  
			    response += "Server: Sunpache 1.0\n";  
			    response += "Content-Type: text/html\n";  
			    response += "Last-Modified: Mon, 11 Jan 1998 13:23:42 GMT\n";  
			    response += "Accept-ranges: bytes \n";  
			    response += "\n"; 
			    response += "<html><head><title>test server</title></head><body><p>Post is ok</p></body></html>";
			    
			
				//out.print( response );
				out.println( response ); 
				out.flush();
				
				out.close();
				in.close();
				socket.close();
			
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
