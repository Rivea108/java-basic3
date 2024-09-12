package last;

public class ExceptionHandle2 {
    public static void main(String[] args) {

    }

    public static void test(int flag) throws Exception{
        //예외 직접 발생시키기 -> 테스트 용도 / 어떤 상태에서는 프로그램 진행되는 것보다  강제로 종료시키고 바로 고치는게 나을 수 있다.
        if (flag == 1) {
            try {
                throw new Exception();//nuhandle exception, checkde exception => 무조건 try - catch 예외 처리 강제
                //익셉션은 객체의 일종이다
            } catch (Exception e) {

               }

                throw new Exception();//nuhandle exception, checkde exception => 무조건 try - catch 예외 처리 강제
                //익셉션은 객체의 일종이다

            } else if (flag == 2) {
            throw new RuntimeException();//runtime exception, uncheckde exception =>  try - catch 예외처리 안해도됨
        }

        System.out.println("hihi");
    }
    }
