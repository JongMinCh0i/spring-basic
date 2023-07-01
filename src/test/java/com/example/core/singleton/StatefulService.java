package com.example.core.singleton;

public class StatefulService {

//    private int price; // 문제가 되는 상태를 유지하는 필드

    public int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
//        this.price = price; // 문제 요소 : 새로운 값들로 초기화된다.
        return price;
    }

//    public int getPrice() {
//        return price;
//    }
}
