package model;

class IdenticalContentSize implements Strategy {
    @Override
    public boolean isContentChanged(String oldContent, String newContent) {
        return oldContent.length() != newContent.length();
    }
}
