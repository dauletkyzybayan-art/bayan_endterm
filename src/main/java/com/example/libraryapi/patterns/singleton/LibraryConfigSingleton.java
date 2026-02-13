package com.example.libraryapi.patterns.singleton;

import org.springframework.core.env.Environment;

public final class LibraryConfigSingleton {

    private static volatile LibraryConfigSingleton instance;

    private String libraryName;
    private int maxBorrowDays;

    private LibraryConfigSingleton() {}

    public static LibraryConfigSingleton getInstance() {
        if (instance == null) {
            synchronized (LibraryConfigSingleton.class) {
                if (instance == null) {
                    instance = new LibraryConfigSingleton();
                }
            }
        }
        return instance;
    }

    public void loadFromEnv(Environment env) {
        this.libraryName = env.getProperty("library.name", "Library");
        this.maxBorrowDays = Integer.parseInt(env.getProperty("library.max-borrow-days", "14"));
    }

    public String getLibraryName() { return libraryName; }
    public int getMaxBorrowDays() { return maxBorrowDays; }
}