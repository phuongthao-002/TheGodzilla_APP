package com.example.models;

public class Notifi {

    int notifiThumb;
    String notifiStatus;

    public Notifi(int notifiThumb, String notifiStatus) {
        this.notifiThumb = notifiThumb;
        this.notifiStatus = notifiStatus;
    }

    public int getNotifiThumb() {
        return notifiThumb;
    }

    public void setNotifiThumb(int notifiThumb) {
        this.notifiThumb = notifiThumb;
    }

    public String getNotifiStatus() {
        return notifiStatus;
    }

    public void setNotifiStatus(String notifiStatus) {
        this.notifiStatus = notifiStatus;
    }
}
