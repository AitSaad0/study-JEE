package com.example.banqueproject.config;

public class PathLooper {

    public static  boolean is_public(String path){
        return AccessPath.public_path().contains(path);
    }

    public static boolean is_private(String path){
        return AccessPath.private_path().contains(path);
    }
}
