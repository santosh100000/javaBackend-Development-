package com.example.L08SpringJPAdemo;

public class SingletonClass {

//    private static SingletonClass instance = new SingletonClass();
 private static SingletonClass instance;
    private SingletonClass(){

    }

//    public static SingletonClass getInstance(){
//        if(instance == null){
//            instance = new SingletonClass();
//        }
////    return instance;
//        return instance;
//    }

    public static synchronized SingletonClass getInstance(){

            synchronized (SingletonClass.class){
                if(instance == null){
                    instance = new SingletonClass();
                }
            }

//    return instance;
        return instance;
    }




}
