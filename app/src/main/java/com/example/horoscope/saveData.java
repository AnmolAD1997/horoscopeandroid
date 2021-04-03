package com.example.horoscope;

public class saveData {

    public String titlesaved;
    public String datasaved;


    public saveData() {

    }

    public saveData(String titlesaved, String datasaved) {
        this.titlesaved = titlesaved;
        this.datasaved = datasaved;
    }

    public String getTitlesaved() {
        return titlesaved;
    }

    public void setTitlesaved(String titlesaved) {
        this.titlesaved = titlesaved;
    }

    public String getDatasaved() {
        return datasaved;
    }

    public void setDatasaved(String datasaved) {
        this.datasaved = datasaved;
    }
}

