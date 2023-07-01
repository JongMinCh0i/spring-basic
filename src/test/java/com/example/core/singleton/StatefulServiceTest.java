package com.example.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

        StatefulService statefulService = ac.getBean("statefulService", StatefulService.class);
        StatefulService statefulService2 = ac.getBean("statefulService", StatefulService.class);

        // ThreadA: A사용자 2000 주문
        statefulService.order("userA", 2000);

        // ThreadB: B사용자 100000 주문
        statefulService2.order("userB", 100000);

        // ThreadA: A사용자 주문 금액 조회
//        int price = statefulService.getPrice();

        // ThreadA: 결과는 예상과는 다르게 B 사용자의 금액인 100000 출력됨
//        System.out.println("price = " + price);
//
//        Assertions.assertThat(statefulService.getPrice()).isEqualTo(2000);
    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }

}