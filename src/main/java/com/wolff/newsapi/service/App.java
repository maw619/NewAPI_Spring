package com.wolff.newsapi.service;



import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        NewsDaoService s = new NewsDaoService();
        s.writeToFile();
    }
}
