package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RefereeTest {
    private static final List<Integer> ANSWER = Arrays.asList(1, 2, 3);
    private Referee referee;

    // 테스트마다 실행되는 메소드
    @BeforeEach
    void setUp(){
        referee = new Referee();
    }

    // 하나의 메소드에 테스트 케이스를 여러개 실행할 수 있음
    @ParameterizedTest
    @CsvSource({"1,2,3,0 볼 3 스트라이크","7,8,9,아웃"})
    public void compare(int number1, int number2, int number3, String expected){
        String actual = referee.compare(ANSWER,Arrays.asList(number1,number2,number3));
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 스트라이크3(){
        String result = referee.compare(ANSWER,Arrays.asList(1,2,3));
        assertThat(result).isEqualTo("0 볼 3 스트라이크");
    }

    @Test
    void 아웃(){
        String result = referee.compare(Arrays.asList(4,5,6),Arrays.asList(1,2,3));
        assertThat(result).isEqualTo("아웃");
    }

    @Test
    void 볼3(){
        String result = referee.compare(Arrays.asList(4,5,6),Arrays.asList(5,6,4));
        assertThat(result).isEqualTo("3 볼 0 스트라이크");
    }

    @Test
    void 볼2스트라이크1(){
        String result = referee.compare(Arrays.asList(4,5,6),Arrays.asList(4,6,5));
        assertThat(result).isEqualTo("2 볼 1 스트라이크");
    }

}