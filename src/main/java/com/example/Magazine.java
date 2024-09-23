package com.example;

public class Magazine {
    private String nameMagazine;
    private String textMagazine;

    public Magazine(String nameMagazine) {
        this.nameMagazine = nameMagazine;
    }

    public Magazine(String nameMagazine, String textMagazine) {
        this.nameMagazine = nameMagazine;
        this.textMagazine = textMagazine;
    }

    public String getNameMagazine() {
        return nameMagazine;
    }

    public void setNameMagazine(String nameMagazine) {
        this.nameMagazine = nameMagazine;
    }

    public String getTextMagazine() {
        return textMagazine;
    }

    public void setTextMagazine(String textMagazine) {
        this.textMagazine = textMagazine;
    }
}
