package spring.aop.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;


public class LogAroundAdvice implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("===============  Around ================");
        long start = System.currentTimeMillis();

        //실제 코어업무라고 치는 놈
        Object result = methodInvocation.proceed();

        long end = System.currentTimeMillis();

        String message = (end - start) + "ms 걸렸습니다.";
        System.out.println(message);

        System.out.println("===============  Around ================");
        return result;
    }
}
