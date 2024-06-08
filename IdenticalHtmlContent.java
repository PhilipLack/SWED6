package model;

class IdenticalHtmlContent implements Strategy {
    @Override
    public boolean isContentChanged(String oldContent, String newContent) {
        return !oldContent.equals(newContent);
    }
}