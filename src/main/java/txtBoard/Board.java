package txtBoard;

import java.util.ArrayList;
import java.util.Scanner;

public class Board {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Post> posts = new ArrayList<>();
        int lastestId = 1; // 가장 최신의 id값. id값의 고유성을 유지하기 위해 1씩 증가시킬 계획임.

        while (true) {
            System.out.print("명령어 : ");
            String command = sc.nextLine();

            if (command.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if (command.equals("add")) {
                System.out.print("게시물 제목을 입력해주세요 : ");
                String title = sc.nextLine();
                System.out.print("게시물 내용을 입력해주세요 : ");
                String body = sc.nextLine();

                // 1부터 1씩 증가 -> 고유값 유지하는데 편리

                Post post = new Post(lastestId, title, body);
//                post.setTitle(title);
//                post.setBody(body);

                posts.add(post);
                System.out.println("게시물이 등록되었습니다.");
                lastestId++; // 다음 게시물의 id를 부여하기 위해 1 증가

            } else if (command.equals("list")) {
//                System.out.println("==================");
//                for(int i = 0; i < posts.size(); i++) {
//                    System.out.printf("번호 : %d\n", posts.get(i).getId());
//                    System.out.printf("제목 : %s\n", posts.get(i).getTitle());
//                    System.out.printf("내용 : %s\n", posts.get(i).getBody());
//                    System.out.println("==================");
//                }

                System.out.println("==================");
                for (Post post : posts) {
                    System.out.printf("번호 : %d\n", post.getId());
                    System.out.printf("제목 : %s\n", post.getTitle());
                    System.out.println("==================");
                }
            } else if (command.equals("update")) {

                System.out.print("수정할 게시물 번호 : ");
                int targetId = Integer.parseInt(sc.nextLine());

                // 논리연산자
                // 조건1 || 조건2 -> 조건1 조건2 둘 중 하나만 만족해도 실행
                // 조건1 && 조건2 -> 조건1 조건2가 동시에 만족(모두 만족)해야만 실행
//                if(targetIdx < 1 || targetIdx > posts.size()) {
//                    System.out.println("없는 게시물 번호입니다.");
//                    continue;
//                }

                for (Post post : posts) {
                    if (post.getId() == targetId) {
                        System.out.print("수정할 제목 : ");
                        String newTitle = sc.nextLine();
                        System.out.print("수정할 내용 : ");
                        String newBody = sc.nextLine();

                        post.setTitle(newTitle);
                        post.setBody(newBody);
                        System.out.println("수정이 완료되었습니다.");
                        break;
                    }
                }


//                Post newPost = new Post(newTitle, newBody);
//                posts.set(targetIdx - 1, newPost); // 원하는 위치의 post를 newPost로 교체

//                Post post = posts.get(targetIdx - 1);
//                post.setTitle(newTitle);
//                post.setBody(newBody);
            } else if (command.equals("delete")) {
                System.out.print("삭제할 게시물 번호 : ");
                int targetId = Integer.parseInt(sc.nextLine());

                for (Post post : posts) {
                    if (post.getId() == targetId) {
                        posts.remove(post); // index가 아닌 값을 넣어서 해당 값을 삭제할 수도 있다.
                        System.out.println("삭제가 완료되었습니다.");
                        break;
                    }
                }
            } else if (command.equals("detail")) {
                System.out.print("상세보기 할 게시물 번호를 입력해주세요 : ");
                int targetId = Integer.parseInt(sc.nextLine());


            }


        }
    }
}