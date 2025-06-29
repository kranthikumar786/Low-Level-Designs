import java.security.MessageDigest;
public class HashGenerator {
private static final int TRUNCATE_BYTES = 6;
public long hashToLong(String input) {
    try{
        MessageDigest  md  = MessageDigest.getInstance("SHA-256");
         byte[] hash = md.digest(input.getBytes());
         long id = 0;
         for(int i = 0 ;i < TRUNCATE_BYTES ; i++) {
              id = (id<<8) | (hash[i] & 0xFF);
         }
         return id;
    }catch (Exception e) {
        throw new RunTimeException("Hash Genration fialed",e);
    }
}
}