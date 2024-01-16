package other;

import java.util.HashMap;

public class URLShortener {

    private HashMap<String, String> urlMap;

    URLShortener() {
        urlMap = new HashMap<>();
    }

    public String shortenURL(String url) {
        String shortURL = url.substring(0, 5);
        urlMap.put(shortURL, url);
        return shortURL;
    }

    public void redirect(String shortURL) {
        String originalURL = urlMap.get(shortURL);
        if (originalURL != null)
            System.out.println("Redirecting to " + originalURL);
        else
            System.out.println("Url not found");
    }
    
}
