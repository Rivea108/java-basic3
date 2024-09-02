package day7.casting;

import java.lang.reflect.Type;

public class Exam2 {
    public static void main(String[] args) {

        weapon weapon = new weapon();
        weapon = new Bow();
        weapon = new Spear();

//        weapon w1 = new weapon();
//        w1.type();

        Bow b1 = new Bow();
        b1.blast();

        Spear s1 = new Spear();
        s1.prod();

        weapon w1 = b1;
        w1.type();
    }
}

class weapon {
    public void type() {
        System.out.println("휘두르다.");
    }
}

class Bow extends weapon{
    public void blast () {
        System.out.println("쏘다.");
    }
}

class Spear extends weapon{
    public void prod() {
        System.out.println("찌르다.");
    }
}