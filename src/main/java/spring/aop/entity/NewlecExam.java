package spring.aop.entity;

public class NewlecExam implements Exam {

    private int kor;
    private int eng;
    private int math;
    private int com;

    @Override
    public int total() {

//        long start = System.currentTimeMillis();

        int result = kor+eng+math+com;

        // AfterThrowing 을 테스트하기 위해 Exception을 발생 시켜봄
        if( kor > 100) throw new IllegalArgumentException("유효하지 않은 국어 점수");


        //로직이 너무 짧아서 시간이 얼마 안걸리기 때문에 일부러 그냥 쓰레드는 잠깐 죽여주는 시간을 넣었음
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        long end = System.currentTimeMillis();
//
//        String message = (end - start) + "ms 걸렸습니다.";
//        System.out.println(message);

        return result;
    }

    @Override
    public float avg() {
        float result = total() / 4.0f;

        return result;
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
