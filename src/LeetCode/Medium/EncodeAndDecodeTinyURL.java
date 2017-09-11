package LeetCode.Medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class EncodeAndDecodeTinyURL {
    //url, tinyUrl
    Map<String, String> urlToTinyUrl = new HashMap<>();
    
    //tinyUrl, url
    Map<String, String> tinyUrlToUrl = new HashMap<>();
    
    Random rnd = new Random();
    
    public EncodeAndDecodeTinyURL() {
        urlToTinyUrl = new HashMap<String, String>();
        tinyUrlToUrl = new HashMap<String, String>();
    }
    
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String tinyUrl = "";
        if(urlToTinyUrl.containsKey(longUrl) == false) {
            tinyUrl = generateTinyUrl();
            
            if(tinyUrlToUrl.containsKey(tinyUrl) == false) {
                urlToTinyUrl.put(longUrl, tinyUrl);
                tinyUrlToUrl.put(tinyUrl, longUrl);
                return tinyUrl;
            } else {
                return encode(longUrl);
            }
        } else {
            return urlToTinyUrl.get(longUrl);
        }
    }
    
    String generateTinyUrl() {
        String tinyUrl = "";
        for(int i = 0; i < 6; i ++) {
            int alphet = rnd.nextInt(25) + 65; // 1~26
            int ALPHET = rnd.nextInt(25) + 97; // 1~26
            int int_ = rnd.nextInt(9); // 0~9
            int type = rnd.nextInt(2) + 1; // 1~3 1:int 2:lowerCase 3: upperCase
            
            switch(type) {
                case 1:
                    tinyUrl += String.valueOf(int_);
                    break;
                case 2:
                    tinyUrl += (char)alphet;
                    break;
                case 3:
                    tinyUrl += (char)ALPHET;
                    break;
            }
        }
        
        return tinyUrl;
    }
    
    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        if(tinyUrlToUrl.containsKey(shortUrl) == false)
            return "";
        
        return tinyUrlToUrl.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));