package spring.di.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import spring.di.entity.Exam;

// 어노테이션을 통한 객체 생성
//@Component
@Component("console")
public class InlineExamConsole implements ExamConsole {


    //필드 주입 방식 테스트
    @Autowired
//    @Autowired(required = false)
//    @Qualifier("exam2")
    private Exam exam;

    public InlineExamConsole() {
            //필드 주입 방식 테스트해보기 위해 프린트
            System.out.println("constructor");
    }

//    @Autowired
    // 여기에 Qualifier 작성시 오류남
//    @Qualifier("exam2")
    // 주입 방식 테스트를 위해 주석
    public InlineExamConsole(Exam exam) {
//    public InlineExamConsole(/*@Qualifier("exam1")Exam exam1,*/ @Qualifier("exam2")Exam exam2) {
            //주입 방식 테스트해보기 위해 프린트
            System.out.println("Overloaded constructor");

        this.exam = exam;
//        this.exam = exam2;
    }

    @Override
    public void print(){
        // 해당 빈 객체가 없을때에도 되게 로직을 구현하고 싶다면
        if(exam == null)
            System.out.println("total : = " + 0 + "\t    avg : " + 0 + "\t exam is null");
        else
            System.out.println("total : = " + exam.total() + "\t    avg : " + exam.avg());
    }

    // Annotation활용해서 setter를 통해서 DI하게 만들거임!
        //필드 주입을 해보기 위해서 주석
//    @Autowired
//    @Qualifier("exam1")

    @Override
    public void setExam(Exam exam) {
            // 주입 방식 테스트해보기 위해 프린트
            System.out.println("Setter constructor");
        this.exam = exam;
    }
}
