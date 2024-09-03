package day7.castingexam3;

public class Exam3 {
        public static void main(String[] args) {

            Warrior warrior = new Warrior();

            String name = "홍길동";
            warrior.name = name;
            warrior.age = 20;
            warrior.introduce();
            // 안녕하세요 저는 20살 홍길동입니다.

            warrior.weapon = new Bow();
            warrior.attack();
            // 출력 : 홍길동이/가 활로 공격합니다.
            warrior.skill();
            //warrior.skill() = "불화살";
            // 출력 : 홍길동이/가 불화살 스킬을 사용합니다. 1.5배(15)의 피해를 입힙니다.

            warrior.weapon = new Sword();
            warrior.attack();
            // 출력 : 홍길동이/가 칼로 공격합니다.
            warrior.skill();
            //warrior.skill() = "연속 베기 스킬";
            // 출력 : 홍길동이/가 연속 베기 스킬을 사용합니다. 2배(30)의 피해를 입힙니다.
            Bow b1 = new Bow();
            b1.blast();

            Sword s1 = new Sword();
            s1.divide();

            Weapon w1 = s1;
                   w1 = b1;
                   w1.use();

        }
    }
    class Warrior {
        // 인스턴스 변수
        String name;
        // 인스턴스 변수
        int age;
        // 인스턴스 변수
        Weapon weapon;

        void introduce() {
            System.out.println("안녕하세요. 저는 " + age + "살 " + name + " 입니다.");
        }

//        void attack() {
//            System.out.println(name + " 이/가 " + weapon + "로 공격합니다.");
        void attack() {
            System.out.print(name + "이/가 ");
            Sword.divide();
        }
        void skill() {
            //System.out.println(name + "d이/가 " + skill + "을 사용합니다. 2배(30)의 피해를 입힙니다.");
        }
    }

    class Weapon {
        public void use() {
            System.out.println("무기로 공격합니다..");
        }
    }

    class Sword extends Weapon {
        public static void divide() {
            System.out.println("칼로 공격합니다.");
}
    }

    class Bow extends Weapon {
        public void blast() {
            System.out.println("활로 공격합니다.");
        }
    }

