package nl.hogeschool.Connection;

import java.io.IOException;
import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.connection.ConnectionException;
import net.schmizz.sshj.connection.channel.direct.Session;
import net.schmizz.sshj.transport.TransportException;
import net.schmizz.sshj.userauth.keyprovider.KeyProvider;

public abstract class SSHConnection {
    protected static SSHClient sshClient;
    protected static Session session;
    
    public static void setSSHClient() throws IOException{
        sshClient = new SSHClient();
        sshClient.loadKnownHosts();
        sshClient.connect("HostName");
        
        KeyProvider loadKey = sshClient.loadKeys("Key");
        sshClient.authPublickey("root",loadKey);
    }
    
    public static SSHClient getSSHClient(){
        return sshClient;
    }
    
    public static void disconnectSSHClient() throws IOException{
        sshClient.disconnect();
    }
    
    public static void startSession() throws ConnectionException, TransportException{
        session = getSSHClient().startSession();      
    }
    
    public static void endSession() throws TransportException, ConnectionException{
        session.close();
    }
}
