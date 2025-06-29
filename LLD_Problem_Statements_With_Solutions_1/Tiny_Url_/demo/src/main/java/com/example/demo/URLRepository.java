public interface URLRepository {
boolean containsShortCode(String code);
boolean containsLongUrl(String url);
 void save(String shortCode,String longUrl);
 String getUrl(String shortCode);
 String getCode(String longUrl);
}