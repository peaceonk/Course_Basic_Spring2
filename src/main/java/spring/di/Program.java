package spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.di.entity.Exam;
import spring.di.entity.NewlecExam;
import spring.di.ui.ExamConsole;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {


/*      이러한 기능을 분리해서 스프링에게 시킬 수 있음. (지시서 스프링설정이 필요함)

        Exam exam = new NewlecExam();

        //DI : 생성자를 이용하는 방법
//        ExamConsole console = new InlineExamConsole(exam);
//        ExamConsole console = new GridExamConsole(exam);

        // DI : setter를 이용하는 방법
        ExamConsole console = new GridExamConsole();
        console.setExam(exam);
*/

//        ApplicationContext context = new ClassPathXmlApplicationContext("setting.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(NewlecDIConfig.class);

        //이름으로 꺼내는 방법 (getBean은 object타입으로 나오므로 캐스팅을 해주어야함)
        ExamConsole console = (ExamConsole) context.getBean("console");

        // 자료형 명으로 꺼내는 방법
        // 여기서는 ExamConsole의 타입에 맞는 녀석을 달라고 호출한 것.
//        ExamConsole console = context.getBean(ExamConsole.class);
        // 만약 같은 자료형을 쓰는 것이 또 있다면 구분할 수 있는 방법을 추가해줘야함

        console.print();


        // 생성자 주입방식 에서 값이 잘 출력 되는지 확인하기 위해서 생성
        // Anootation @Autowired를 활용함에 있어서 문제가 될 수있으므로 주석처리
//        Exam exam = context.getBean(Exam.class);
//        System.out.println(exam.toString());


            // @Autowired 동작원리 이해를 위해서 간단한 기능만 남기기위해 주석
/*        // 목록 및 콜렉션 DI로 가져와 출력 테스트를 위해서
//        List<Exam> exams = new ArrayList<>();
        List<Exam> exams = (List<Exam>) context.getBean("exams");
        //DI 자체를 리스트 형식으로 했기 때문에 주석처리해줌
//        exams.add(new NewlecExam(1,1,1,1));

        for(Exam e : exams) System.out.println("e = " + e);*/

    }
}
