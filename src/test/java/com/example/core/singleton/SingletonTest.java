package com.example.core.singleton;

import com.example.core.AppConfig;
import com.example.core.discount.DiscountPolicy;
import com.example.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {
        AppConfig ac = new AppConfig();

        DiscountPolicy discountPolicy = ac.discountPolicy();

        DiscountPolicy discountPolicy1 = ac.discountPolicy();

        System.out.println("discountPolicy = " + discountPolicy);
        System.out.println("discountPolicy1 = " + discountPolicy1);

        Assertions.assertThat(discountPolicy).isNotEqualTo(discountPolicy1);
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    public void singletonService() {
        SingletonService instance = SingletonService.getInstance();
        SingletonService instance1 = SingletonService.getInstance();


        System.out.println("instance  = " + instance);
        System.out.println("instance1 = " + instance1);

        Assertions.assertThat(instance).isSameAs(instance1);

        instance1.logic();
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer() {

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        //1. 조회 : 호출할 때 마다 같은 객체를 반환
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        //2.참조값이 같은 것을 확인
        System.out.println("memberService = " + memberService);
        System.out.println("memberService2 = " + memberService2);

        Assertions.assertThat(memberService).isSameAs(memberService2);
    }
}
