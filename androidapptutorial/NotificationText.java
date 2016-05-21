package com.example.stealkel2.androidapptutorial;


public class NotificationText {
    private  String setNotiTilte;
    private  String setNotiText;
    NotificationText(){
        this.setNotiTilte = null;
        this.setNotiText = null;
    }
    public void setNotiText(String setNotiText){
        this.setNotiText = setNotiText;
    }
    public  void setSetNotiTilte(String setNotiText){
        this.setNotiTilte = setNotiText;
    }
    public String getNotiText(){
        return this.setNotiText;
    }
    public String getNotiTilte(){
        return this.setNotiTilte;
    }
}
