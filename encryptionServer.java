import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class encryptionServer {
    public static void main(String[] args) {
//        encryption productCipher=new encryption();
        AffineCipher affineCipher=new AffineCipher();
        TranspositionCipher tc=new TranspositionCipher();
        do{
        try{
            ServerSocket ss=new ServerSocket(1234);
            Socket s=ss.accept();//establishes connection
            DataInputStream dis=new DataInputStream(s.getInputStream());
            String str=dis.readUTF();
            if(str.equals("Exit")){
                System.exit(0);
            }
            System.out.println("encrypted messaage recieved:"+str);
            System.out.println("message after decryption= "+affineCipher.decryptionMessage(tc.doDecryption(str)));
            ss.close();
        }catch(Exception e){System.out.println(e);}


        }while(true);

    }
}
