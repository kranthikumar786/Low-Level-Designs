import java.util.HashMap;
import java.util.Map;
public class InMemoryUrlRepository implements URLRepository{
  private final Map<String,String>codeToUrl = new HashMap<>();
  private final Map<String,String>urlToCode = new HashMap<>();
  public boolean containsShortCode(String code){
      return codeToUrl.containsKey(code);
  }
  public boolean containsLongUrl(String url) {
      return urlToCode.containsKey(url);
  }
  public void save(String code, String url) {
      codeToUrl.put(code,url);
      urlToCode.put(url,code);
  }
  public Stirng getUrl(String code) {
      return codeToUrl.get(code);
  }
  public String getCode(String url) {
      return utlToCode.get(url);
  }
}