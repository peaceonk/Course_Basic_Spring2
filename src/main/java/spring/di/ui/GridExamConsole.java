package spring.di.ui;

import spring.di.entity.Exam;

public class GridExamConsole implements ExamConsole{

    private Exam exam;

    public GridExamConsole(Exam exam) {
        this.exam = exam;
    }
    public GridExamConsole() {
    }

    @Override
    public void print(){
        System.out.println("-------------------------------------");
        System.out.println("total : = " + exam.total() + "\t   avg : "+ exam.avg());
        System.out.println("-------------------------------------");
    }

    @Override
    public void setExam(Exam exam) {
        this.exam = exam;
    }
}
