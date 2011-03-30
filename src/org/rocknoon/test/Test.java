package org.rocknoon.test;

import org.rocknoon.httpserver.Server;

public class Test {

	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int port 	= 80;
		String path = new String("e:/www");
		
		Server server = new Server( port , path );
		server.start();
		
	}

}
