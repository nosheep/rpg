package com.nosheep.network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {

	private Socket socket;
	private DataInputStream in;
	private DataOutputStream out;
	
	public Client() {
		
	}
	
	public void connect() throws Exception{
		socket = new Socket("", 60003);
		in = new DataInputStream(socket.getInputStream());
		out = new DataOutputStream(socket.getOutputStream());
	}
	
	public void sendMessage() {
		try{
			byte[] message = "Hej".getBytes("US-ASCII");
			out.write(message);
		}
		catch(NullPointerException | IOException ex){}
	}
	
	public String getData(){
		try{
			while(in.read() != -1){
				byte[] b = new byte[1000];
				in.read(b, 0, 1000);
				return new String(b, "US-ASCII");
			}
			Thread.sleep(17);
		}
		catch(Exception ex){
			return null;
		}
		return null;
	}

	public boolean IsConnected(){
		if(socket != null){
			if(!socket.isConnected() || !socket.isClosed())
				return true;
			else
				return false;
		}
		else return false;
	}
	
	public void disconnect() {
		try{
			socket.shutdownInput();
			socket.shutdownOutput();
			socket.close();
		}
		catch(Exception ex){}
	}

}
