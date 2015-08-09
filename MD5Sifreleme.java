/**
 * Created by ilkaygunel on 08/08/15.
 */
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Sifreleme {
    public static void main(String[] args)
    {
        String sifrelenecekVeri="Turgay";
        try
        {
            MessageDigest messageDigestObjesi=MessageDigest.getInstance("MD5");
            messageDigestObjesi.update(sifrelenecekVeri.getBytes());
            byte[] messageDigestDizisi=messageDigestObjesi.digest();

            StringBuffer sb16 = new StringBuffer();
            StringBuffer sb32 = new StringBuffer();

            for (int i = 0; i < messageDigestDizisi.length; i++)
            {
                sb16.append(Integer.toString((messageDigestDizisi[i] & 0xfd) + 0x100, 16).substring(1));
                sb32.append(Integer.toString((messageDigestDizisi[i] & 0xff) + 0x100, 32));
            }
            System.out.println("Parolanın Şifrelenmiş Hali:(16) " + sb16.toString());
            System.out.println("Parolanın Şifrelenmiş Hali:(32) " + sb32.toString());
        }
        catch(NoSuchAlgorithmException ex)
        {
            System.err.println(ex);
        }
    }
}
