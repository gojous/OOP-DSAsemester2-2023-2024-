package network;
import java.io.IOException;
import java.io.InetAddress;
import java.net.Socket;
public class Client extends NetworkEntity{
   private String hostName;
   private int serverPort;
   public Client(final String host,final int port){
            super("CLIENT");
         hostName=host;
         serverPort=port;
   }
   public void run(){
    try{
        connectToServer();
        getStreams();
        processIncomingData();
    }
    catch(IOException e){
        e.printStackTrace();}
    finally{
        closeConnection();}
    }
    private void connectToServer(){
        try{
            connectionHandle = new Socket(java.net.InetAddress.getByName(hostName),serverPort);
        }
        catch(IOException e){
         }
    }
}
