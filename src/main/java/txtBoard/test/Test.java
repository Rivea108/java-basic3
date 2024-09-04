package txtBoard.test;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Person p1 = new Person();

        setPerson(p1);

        p1.intro();

        Person p2 = getPerson();

        p2.intro();

        ArrayList<String> arr = new ArrayList<>();

        mytest(arr);

        System.out.println(arr.get(0));
        System.out.println(arr.get(1));
        System.out.println(arr.get(2));
    }

    // main에서 arr을 넘겨받아 "apple", "banana", "orange" 저장
    public static void mytest(ArrayList<String> param) {
        //arr은 어레이리스트이기에 mytest(ArrayList<String> param) 어레이리스트 스트링으로 받고
        // 그다음 매개변수에 이름 내마음대로 적어서 하면된다
        param.add("apple");
        param.add("banana");
        param.add("orange");

    }

    public static Person getPerson() {
        Person p = new Person();
        p.age = 30;
        p.name = "이순신";

        return p;
    }

    public static void setPerson(Person a) {
        a.age = 20;
        a.name = "홍길동";
    }
}

class Person {
    int age;
    String name;

    public void intro() {
        System.out.printf("%d살 %s입니다.\n", age, name);
    }
}