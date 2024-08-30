package day6.kiosk;

import java.util.ArrayList;
import java.util.Scanner;

public class Berger {
    public static void main(String[] args) {
        // 햄버거 키오스크 만들기

        ArrayList<Burger> burgers = new ArrayList<>();
        ArrayList<Burger> burgerCart = new ArrayList<>();
        ArrayList<Side> Side = new ArrayList<>();
        ArrayList<Side> SideCart = new ArrayList<>();
        ArrayList<Drinkables> Drinkables = new ArrayList<>();
        ArrayList<Drinkables> DrinkablesCart = new ArrayList<>();

        Burger b1 = new Burger("한우불고기버거", 6000);
        Burger b2 = new Burger("치즈버거", 3000);
        Burger b3 = new Burger("치킨버거", 3500);
        Burger b4 = new Burger("새우버거", 3200);

        burgers.add(b1);
        burgers.add(b2);
        burgers.add(b3);
        burgers.add(b4);

        Side s1 = new Side("감자튀김", 1800);
        Side s2 = new Side("치즈스틱", 2000);
        Side s3 = new Side("치킨너겟", 2500);
        Side s4 = new Side("오징어링", 2700);

        Side.add(s1);
        Side.add(s2);
        Side.add(s3);
        Side.add(s4);

        Drinkables d1 = new Drinkables("콜라", 1000);
        Drinkables d2 = new Drinkables("에이드", 2000);
        Drinkables d3 = new Drinkables("커피", 1500);
        Drinkables d4 = new Drinkables("쉐이크", 2500);

        Drinkables.add(d1);
        Drinkables.add(d2);
        Drinkables.add(d3);
        Drinkables.add(d4);

        Scanner sc = new Scanner(System.in);
        System.out.println("햄버거 키오스크 v1");
        while (true) {
            System.out.println("1. 햄버거 선택");
            System.out.println("2. 사이드 선택");
            System.out.println("3. 음료수 선택");
            System.out.println("4. 메뉴 취소");
            System.out.println("5. 주문 하기");
            System.out.println("====== 주문 목록 =====");

            System.out.print("버거: [");
            for (int i = 0; i < burgerCart.size(); i++) {
                System.out.print(burgerCart.get(i).name + " ");
            }
            System.out.println("]");

            System.out.print("사이드: [");
            for (int i = 0; i < SideCart.size(); i++) {
                System.out.print(SideCart.get(i).name + " ");
            }
            System.out.println("]");

            System.out.println("음료수: []");
            System.out.println("총금액 : 0");
            System.out.print("무엇을 하시겠습니까 : ");
            int menu = Integer.parseInt(sc.nextLine());

            if (menu == 1) {
                System.out.println("=== 버거 목록 ===");
                for (int i = 0; i < burgers.size(); i++) {
                    System.out.printf("%d. %s %d\n", i + 1, burgers.get(i).name, burgers.get(i).price);
                }

                System.out.print("어떤 버거를 고르시겠습니까 : ");
                int selectNo = Integer.parseInt(sc.nextLine()); // 번호로 버거 선택

                Burger burger = burgers.get(selectNo - 1); // 선택한 번호로 버거 가져오기
                burgerCart.add(burger); // 카트에 선택한 버거 추가
                System.out.println("한우불고기버거를 고르셨습니다.");

            }

            if (menu == 2) {
                System.out.println("=== 사이드 목록 ===");
                for (int i = 0; i < Side.size(); i++) { // 'Side'를 'sides'로 수정
                    System.out.printf("%d. %s %d\n", i + 1, Side.get(i).name, Side.get(i).price);
                }
                System.out.print("어떤 사이드 메뉴를 고르시겠습니까 : ");
                int selectNo = Integer.parseInt(sc.nextLine()); // 번호로 버거 선택

                Side side = Side.get(selectNo - 1); // 선택한 번호로 사이드 가져오기
                SideCart.add(side); // 카트에 선택한 사이드 추가
                System.out.println(side.name + "을(를) 고르셨습니다.");

            }
        }
            }
        }

