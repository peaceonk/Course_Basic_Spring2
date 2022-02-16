package spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.di.entity.Exam;
import spring.di.entity.NewlecExam;
import spring.di.ui.ExamConsole;

public class Program {
    public static void main(String[] args) {
        Exam exam = new NewlecExam();

/*      이러한 기능을 분리해서 스프링에게 시킬 수 있음. (지시서/스프링설정이 필요함)
        //DI : 생성자를 이용하는 방법
//        ExamConsole console = new InlineExamConsole(exam);
//        ExamConsole console = new GridExamConsole(exam);

        // DI : setter를 이용하는 방법
        ExamConsole console = new GridExamConsole();
        console.setExam(exam);
*/

        ApplicationContext context = new ClassPathXmlApplicationContext("setting.xml");

        //이름으로 꺼내는 방법 (getBean은 object타입으로 나오므로 캐스팅을 해주어야함)
//        ExamConsole console = (ExamConsole) context.getBean("console");

        // 자료형 명으로 꺼내는 방법
        // 여기서는 ExamConsole의 타입에 맞는 녀석을 달라고 호출한 것.
        ExamConsole console = context.getBean(ExamConsole.class);
        // 만약 같은 자료형을 쓰는 것이 또 있다면 구분할 수 있는 방법을 추가해줘야함

        console.print();
    }
}
