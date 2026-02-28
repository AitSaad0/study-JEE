package com.example.banqueproject.config;

public class PathLooper {

    public static boolean is_public(String path) {
        return path.endsWith("/auth")
                || path.endsWith("/home")
                || path.endsWith("/register")
                || path.endsWith("/logout")
                || path.contains("/css/")
                || path.contains("/js/")
                || path.contains("/images/");
    }
}
