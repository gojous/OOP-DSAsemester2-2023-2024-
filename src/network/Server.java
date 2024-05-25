package network;
import java.io.IOException;
import java.io.ServerSocket;
public class Server extends NetworkEntity{
    private ServerSocket server;
    private int port;
    public Server(final int port){
        super("SERVER");
        this.port=port;
    }
    public void run(){
        try{
            serverSocket=new ServerSocket(port,1);
            while(true){
                try{
                    waitForConnection();
                    getStream();
                    processIncomingData();
                }catch(IOException e){
                    e.printStackTrace();
                }finally{
                    closeConnection();
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    private void waitForConnection() throws IOException{
        connectionHandle=serverSocket.accept();
    }
    public void closeConnection(){
        super.closeConnection();
        try{
            server.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
