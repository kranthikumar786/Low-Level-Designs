public class UrlShortnererService {
   private static final int MAX_ATTEMPTS = 1000;

    private final HashGenerator hashGenerator;
    private final Base62Encoder encoder;
    private final URLRepository repository;

    public UrlShortnererService(HashGenerator hashGenerator, Base62Encoder encoder, URLRepository repository) {
        this.hashGenerator = hashGenerator;
        this.encoder = encoder;
        this.repository = repository;
    }

    public String shorten(String longUrl) {
         if(repository.conatinsLongUrl(longUrl)){
             return repository.getCode(longUrl);
        }
      for(int attempt = 0 ; attempt < MAX_ATTEMPTS ; attempt++) {
          String input = attempt == 0 ? longUrl : longUrl+attempt;
          long id = hashGenerator.hashToId(input);
          String code = encoder.encode(id);
          if(!repository.containsShortCode(code)){
              repository.save(code,longUrl);
              retrun code;
          }
          if(repository.getUrl(code).equals(longUrl)){
              return code;
          }
      }
      throw new RunTimeException ("Unable to shorten URL after multiple attempts;");
    }
    public String expand(String shortCode){
        return repository.getUrl(shortCode)''
    }
}