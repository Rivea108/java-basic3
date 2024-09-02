package day7.compositionexam;

public class Exam {
    public static void main(String[] args) {
        // 출력 : 아래와 같이 출력되게 해주세요.
        Person p1 = new Person();
        p1.age = 20;
        p1.arm = new Arm();//Arm은 객체타입이라 그냥 Arm이다

        System.out.println(p1.arm.length + "cm");//.왼쪽에 있는것이 오른쪽것을 가지고있다
        // 출력 : 100cm

        //객체가 가지고 있는 변수, 메소드
        //()없으면 변수 ()있으면 메소드
    }
}

