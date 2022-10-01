package com.iacit.api.controller;

import lombok.Data;

@Data
public class Parms {
    String a;
	String b;
    public void setA(String a) {
        this.a = a;
    }
    public void setB(String b) {
        this.b = b;
    }
    public String getA() {
        return a;
    }
    public String getB() {
        return b;
    }
}