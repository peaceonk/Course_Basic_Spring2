package spring.aop.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class LogBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {

        System.out.println("===============  Before ================");
        System.out.println("앞에서 실행될 로직 : 서브업무에 해당하는 내용");

        // 여기서 만약에 현재 호출되고 있는 함수에 대한 이름 or 파라미터에 대한 정보를 가져오고 싶으면
        // method를 쓰면 됨.
        System.out.println("method.getName() = " + method.getName());

        // 타켓에 대한 객체를 이용하고 싶다면
        // o를 쓰면 됨.
        System.out.println(o.toString());
        System.out.println(o.hashCode());
        System.out.println(o.getClass());
        System.out.println("===============  Before ================");
    }
}
