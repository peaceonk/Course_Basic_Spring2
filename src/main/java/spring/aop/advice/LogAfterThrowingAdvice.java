package spring.aop.advice;

import org.springframework.aop.ThrowsAdvice;

public class LogAfterThrowingAdvice implements ThrowsAdvice {
    // 기존의 다른 형태( Around / Before / AfterReturning )와 다르게
    // ThrowsAdvice가 구현해야할 함수가 정해질 수 없어서 인자가 정해져 있지 않다.

    // IllegalArgumentException 에 들어갈 것을 정할 수 없다는 의미!
    public void afterThrowing(IllegalArgumentException e) throws Throwable {
        //1. Before
        //2. 타겟의 method가 실행됨
        //3. AfterReturingAdvice
        // 위 순서대로 로직이 진행되는데 되는 중에 Exception이 발생하면 afterThrowing으로 들어오게 된다.

        System.out.println("===============  AfterThrowing ================");

        System.out.println("예외가 발생하였습니다. : " + e.getMessage());

        System.out.println("===============  AfterThrowing ================");
    }
}
