import java.util.Scanner;

public class AffineCipher
{
    public static String encryptionMessage(String Msg)
    {
        String CTxt = "";
        String[] array=Msg.split("\\s+");
        int a = 3;
        int b =6;
        for(int i=0;i<=array.length-1;i++) {
            for (int j = 0; j < array[i].length(); j++) {
                CTxt = CTxt + (char) ((((a * array[i].charAt(j)) + b) % 26) + 65);
            }

            CTxt+=" ";
        }

        return CTxt;
    }

    public static String decryptionMessage(String CTxt)
    {

        String[] array=CTxt.split("\\s+");

        String Msg = "";
        int a = 3;
        int b =6;
        int a_inv = 0;
        int flag = 0;
        for (int i = 0; i < 26; i++)
        {
            flag = (a * i) % 26;
            if (flag == 1)
            {
                a_inv = i;
//                System.out.println(i);
            }
        }
        for(int k=0;k<=array.length-1;k++){
            for (int j = 0; j <array[k].length(); j++)
            {
                Msg = Msg + (char) (((a_inv * ((array[k].charAt(j) - b)) % 26)) + 65);
            }

            Msg+=" ";
        }

        Msg=Msg.replaceAll("%3f", "").replaceAll("[?]", "");
        return Msg.toLowerCase();
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the message: ");
        String message = sc.nextLine();

        System.out.println("Encrypted Message is : "
                + encryptionMessage(message.toUpperCase()));
        System.out.println("Decrypted Message is: "
                + decryptionMessage(encryptionMessage(message)));
        sc.close();
    }
}