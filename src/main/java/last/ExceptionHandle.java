package last;

import java.util.ArrayList;

public class ExceptionHandle {
    public static void main(String[] args) {

        ArrayList<String> arr = new ArrayList<>();

        arr.add("apple");
        arr.add("banana");
        arr.add("orenge");

        try {
            System.out.println(arr.get(3));//예외 발생 코드
            //3번은 없기에 익셉션 오류(너무 직관적)가 나온다
        } catch (IndexOutOfBoundsException a) {
            System.out.println("3번 인덱스는 없다.");
        }

        try {
            System.out.println(arr.get(3)); //2개의 에러코드가 있다
            System.out.println(10 / 0);
        } catch (ArithmeticException a) {//여기선 (10 / 0)의 캐치만 있기때문에 어레이리스트의 에러는 넘기지 못한다
            System.out.println("나눌수 없다");
        } catch (IndexOutOfBoundsException a) {//그렇기에 새로를 하나 만든거다
            System.out.println("3번 인덱스는 없다.");
        }

        try {
            System.out.println(arr.get(3)); //2개의 에러코드가 있다
            System.out.println(10 / 0);
        } catch (ArithmeticException a) {//여기선 (10 / 0)의 캐치만 있기때문에 어레이리스트의 에러는 넘기지 못한다
            System.out.println("나눌수 없다");
        } catch (IndexOutOfBoundsException a) {//그렇기에 어레이리스트의 캐치를 하나 만든거다
            System.out.println("3번 인덱스는 없다.");
        } finally {//캐치 이후 무조건 실행된다.
            System.out.println("여기는 무조건 실행되고 끝남.");
        }

        System.out.println("hihi.");

    }
}
