package cashdesk.utils;

import org.apache.log4j.Logger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Make MD5 hashing, using for passwords
 *
 * @author Anatolii Huzov
 * @version 1.0
 */
public class MD5 {
    private static MessageDigest md;
    private static final Logger LOGGER = Logger.getLogger(MD5.class);

    public static String MD5(String pass){
        try {
            md = MessageDigest.getInstance("MD5");
            byte[] passBytes = pass.getBytes();
            md.reset();
            byte[] digested = md.digest(passBytes);
            StringBuffer sb = new StringBuffer();
            for(int i=0;i<digested.length;i++){
                sb.append(Integer.toHexString(0xff & digested[i]));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException ex) {
           LOGGER.debug ( "MD5 error" );
        }
        return null;


    }
}
