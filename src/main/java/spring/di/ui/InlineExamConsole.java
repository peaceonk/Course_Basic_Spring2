package spring.di.ui;

import org.springframework.beans.factory.annotation.Autowired;
import spring.di.entity.Exam;

public class InlineExamConsole implements ExamConsole {

    private Exam exam;

    public InlineExamConsole() {

    }

    public InlineExamConsole(Exam exam) {
        this.exam = exam;
    }

    @Override
    public void print(){
        System.out.println("total : = " + exam.total() + "\t    avg : "+ exam.avg());
    }

    // Annotation활용해서 setter를 통해서 DI하게 만들거임!
    @Autowired
    @Override
    public void setExam(Exam exam) {
        this.exam = exam;
    }
}
