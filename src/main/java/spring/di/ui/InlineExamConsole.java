package spring.di.ui;

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

    @Override
    public void setExam(Exam exam) {
        this.exam = exam;
    }
}
