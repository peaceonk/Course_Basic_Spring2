package spring.di.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

    // JAVA Config 파일에서 이 객체를 @bean으로 컨테이너에 담기때문에 어노테이션 주석
//@Component
public class NewlecExam implements Exam {

    //@Component로 객체 생성하기 때문에 값을 넣어주려면
    @Value("90")
    private int kor;
    @Value("100")
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
