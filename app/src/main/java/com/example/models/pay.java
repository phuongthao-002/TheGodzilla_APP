package com.example.models;

public class pay {
    int paymeThumb;
    String paymeName;

    public pay(int paymeThumb, String paymeName) {
        this.paymeThumb = paymeThumb;
        this.paymeName = paymeName;
    }

    public int getPaymeThumb() {
        return paymeThumb;
    }

    public void setPaymeThumb(int paymeThumb) {
        this.paymeThumb = paymeThumb;
    }

    public String getPaymeName() {
        return paymeName;
    }

    public void setPaymeName(String paymeName) {
        this.paymeName = paymeName;
    }
}
