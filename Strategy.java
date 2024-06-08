package model;

interface Strategy {
    boolean isContentChanged(String oldContent, String newContent);
}
