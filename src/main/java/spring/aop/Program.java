package spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.aop.entity.Exam;
import spring.aop.entity.NewlecExam;
import spring.di.NewlecDIConfig;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Program {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("setting-aop.xml");
//        ApplicationContext context = new AnnotationConfigApplicationContext(NewlecDIConfig.class);

        Exam proxyExam = (Exam) context.getBean("proxy");

        System.out.printf("total is %d\n",proxyExam.total());
        System.out.println(" =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= ");
        System.out.printf("avg is %f\n",proxyExam.avg());


/* 여기에 해당한느 내용을 전부 setting-aop.xml 즉 스프링의 설정으로 꺼낼것임[ 느슨한 결합 관계로 인해 유지보수가 편하고 아주 많은 이유로~]

        Exam exam = new NewlecExam(1,1,1,1);

                                                //NewlecExam의 실질적인 객체를 load할 수있도록 객체를 넘겨줌
        Exam proxyExam = (Exam) Proxy.newProxyInstance(NewlecExam.class.getClassLoader(),
                // Class의 배열형태로 Exam이라는 녀석을 넘겨줌
                new Class[] {Exam.class},
                // 인터페이스를 구현하는 클래스를 객체화하는 작업을 하려면 별도의 클래스파일을 만들어야하는데
                // InvocationHandler라는 익명클래스를 작성해줌
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        long start = System.currentTimeMillis();

                        //실제 코어 업무를 할 녀석이 method로 오는데 여기에
                        // invoke로 (실제 업무 객체 , 호출하는메소드를 가지고 있는 파라미터인 args) 를 넣어줌
                        Object result = method.invoke(exam, args);

                        long end = System.currentTimeMillis();

                        String message = (end - start) + "ms 걸렸습니다.";
                        System.out.println(message);

                        return result;
                    }
                });

//        System.out.printf("total is %d\n",exam.total());
//        System.out.printf("avg is %f\n",exam.avg());


        System.out.printf("total is %d\n",proxyExam.total());
        System.out.printf("avg is %f\n",proxyExam.avg());

 */
    }
}
