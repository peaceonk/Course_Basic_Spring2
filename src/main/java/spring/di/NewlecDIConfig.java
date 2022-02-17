package spring.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import spring.di.entity.Exam;
import spring.di.entity.NewlecExam;

// 어떤 패키지를 스캔할 것인지 명시
@ComponentScan("spring.di.ui")
// 이 파일이 Configuration 파일이라는 것을 명시하고 역할을 하도록
@Configuration
public class NewlecDIConfig {

    // 객체를 IoC에 컨테이너에 담도록 @Bean어노테이션을 써주어야함.
    @Bean
    // 이름을 DI 의  ID라고 생각하고 작성해주어야함.
    public Exam exam (){
        return new NewlecExam();
    }

}
