package spring.aop.advice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class LogAfterReturningAdvice implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        //Before와 다르게 호출된 함수의 반환값이 o로 들어온다.

        System.out.println("===============  AfterReturning ================");
        System.out.println("o : returnValue = " + o);
        System.out.println("method = " + method.getName());
        System.out.println("===============  AfterReturning ================");
    }
}
