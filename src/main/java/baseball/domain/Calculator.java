package baseball.domain;

public class Calculator {
    public final int share = 1104; // 상수
    public static int shareResult = 0; // 클래스 변수, '클래스.변수'로 사용가능

    public int result = 0; // 인스턴스 변수

    public Calculator(){
    }

    public int add(int number1, int number2){
        result = number1 + number2;
        shareResult = result;
        return result;
    }
}
