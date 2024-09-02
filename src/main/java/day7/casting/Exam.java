package day7.casting;

public class Exam {
    public static void main(String[] args) {
        // 변수는 수정하지 않습니다.
        int num1 = 10;
        int num2 = 4;
        //num1으로 num2를 나눠야함 10/4 = 2.5
        System.out.println((double)num1 / num2);// 출력 : 2.5
        num2 = num1;
        num2 = (int)num1;
    }
}

