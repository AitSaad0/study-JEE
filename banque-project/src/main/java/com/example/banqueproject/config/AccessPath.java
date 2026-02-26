package com.example.banqueproject.config;

import java.util.ArrayList;
import java.util.List;

public class AccessPath {

    public static List<String> public_path(){
        List<String> paths = new ArrayList<>();
        paths.add("/auth");
        paths.add("/home");
        paths.add("/register");
        return  paths;
    }

    public static List<String> private_path(){
        List<String> paths = new ArrayList<>();
        paths.add("/catalogue");
        return paths;
    }
}
