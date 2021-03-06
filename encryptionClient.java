import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class encryptionClient {
    public static void main(String[] args) {
        
        AffineCipher affineCipher=new AffineCipher();
        TranspositionCipher tc=new TranspositionCipher();
        Scanner scanner=new Scanner(System.in);

        do{
            System.out.println("Enter message to be sent:");
            String plaintext=scanner.nextLine();

            if(plaintext.equals("Exit")){
                System.exit(0);
            }
            else{
                String subCipher=affineCipher.encryptionMessage(plaintext.toUpperCase());
                System.out.println("Encrypted Message sent was: "+ tc.doEncryption(subCipher));



                try{
                    Socket s=new Socket("localhost",1234);
                    DataOutputStream dout=new DataOutputStream(s.getOutputStream());
                    dout.writeUTF(tc.doEncryption(subCipher));
                    dout.flush();
                    dout.close();
                    s.close();
                }catch(Exception e){System.out.println(e);}
            }

        }while(true);

    }
}

