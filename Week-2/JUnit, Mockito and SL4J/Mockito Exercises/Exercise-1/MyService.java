package com.example.mock;

public class MyService {
    private final ExternalApi ex;

    public MyService(ExternalApi ex) {
        this.ex = ex;
    }

    public String fetchData() {
        return ex.getData();
    }
}
