import java.math.BigInteger;
import java.security.MessageDigest;

public class Hash {

        String sha1 = "";

        public String hashing(String value) {

        try {

            MessageDigest digest = MessageDigest.getInstance("SHA-1");

            digest.reset();

            digest.update(value.getBytes("utf8"));

            sha1 = String.format("%040x", new BigInteger(1, digest.digest()));

        } catch (Exception e){

            e.printStackTrace();

        }
        
        return sha1;

  

        }

     }
