package model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

class IdenticalTextContent implements Strategy {
    @Override
    public boolean isContentChanged(String oldContent, String newContent) {
        
        Document oldDoc = Jsoup.parse(oldContent);
        Document newDoc = Jsoup.parse(newContent);

       
        String oldText = oldDoc.text();
        String newText = newDoc.text();

        
        return !oldText.equals(newText);
    }
}
