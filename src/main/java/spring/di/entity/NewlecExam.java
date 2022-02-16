package spring.di.entity;

public class NewlecExam implements Exam {
    private int kor;
    private int eng;
    private int math;
    private int com;

    @Override
    public int total() {
        return kor + eng + math + com;
    }

    @Override
    public float avg() {
        return total() / 4.0f;
    }

    //값 형식의 DI를 하기 위한 Setter 생성
    public void setKor(int kor) {
        this.kor = kor;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public void setCom(int com) {
        this.com = com;
    }

    // 생성자 DI를 위해 기본 생성자와 overload 생성자 추가
    public NewlecExam() {
    }

    public NewlecExam(int kor, int eng, int math, int com) {
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        this.com = com;
    }

    //잘 출력되는지 확인하기 위해 생성
    @Override
    public String toString() {
        return "NewlecExam{" +
                "kor=" + kor +
                ", eng=" + eng +
                ", math=" + math +
                ", com=" + com +
                '}';
    }
}
