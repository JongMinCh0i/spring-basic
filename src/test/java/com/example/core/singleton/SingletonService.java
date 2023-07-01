package com.example.core.singleton;

public class SingletonService {

    // 1. static 영역에 오직 한개의 객체 생성
    private static SingletonService instance = new SingletonService();

    // 2. public으로 열어서 객체 인스턴스가 필요하면 이 static 메서드만을 통해서만 조회하도록 허용
    public static SingletonService getInstance() {
        return instance;
    }

    // 3.외부에서 생성자를 호출할 수 없게 private 선언 오직 인스턴스는 getInstance를 통해서만 조회 가능
    private SingletonService() { }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
