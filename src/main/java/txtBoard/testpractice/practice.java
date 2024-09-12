package txtBoard.testpractice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class practice {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Post> posts = new ArrayList<>();
        int numid = 1;

        while (true) {

            System.out.print("명령어 : ");
            String command = sc.nextLine();


            if (command.equals("exit")) {
                System.out.println("프로그램 종료");
                break;

            } else if (command.equals("add")) {
                System.out.print("게시물 내용을 입력해주세요 : ");
                String title = sc.nextLine();
                System.out.print("게시물 제목을 입력해주세요 : ");
                String body = sc.nextLine();

                LocalDateTime dateTime = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String time = dateTime.format(formatter);

                Post post = new Post(title, body, numid, time);
                posts.add(post);
                numid++;
                System.out.println("게시물이 등록되었습니다.");

            } else if (command.equals("list")) {
                System.out.println("=====");
                for (int i = 0; i < posts.size(); i++) {
                    System.out.println("번호 : " + (i + 1));
                    System.out.println("제목 : " + posts.get(i).getTitle());
                    System.out.println("=====");
                }

            } else if (command.equals("update")) {
                System.out.print("수정할 게시물 번호 : ");
                int number = Integer.parseInt(sc.nextLine());

                if (number < 0 || number >= posts.size()) {
                    System.out.println("없는 게시물 번호입니다.");
                    continue;
                }

                System.out.print("수정할 제목 : ");
                String newtitle = sc.nextLine();
                System.out.print("수정할 내용 : ");
                String newbody = sc.nextLine();

                Post post = posts.get(number - 1);
                post.setTitle(newtitle);
                post.setBody(newbody);

            } else if (command.equals("delete")) {
                System.out.print("삭제할 게시물 번호 : ");
                int number = Integer.parseInt(sc.nextLine()) - 1;

                if (number < 0 || number >= posts.size()) {
                    System.out.println("없는 게시물 번호입니다.");
                    continue;
                }
                posts.remove(number);
                System.out.println("게시물이 삭제되었습니다.");

            } else if (command.equals("detail")) {
                System.out.print("상세보기 할 게시물 번호 : ");
                int number = Integer.parseInt(sc.nextLine()) - 1;

                if (number < 0 || number >= posts.size()) {
                    System.out.println("없는 게시물 번호입니다.");
                    continue;
                }

                Post post = posts.get(number - 1);
                System.out.println("=====");
                System.out.println("번호 : " + post.getId());
                System.out.println("제목 : " + post.getTitle());
                System.out.println("내용 : " + post.getBody());
                System.out.println("등록날짜 : " + post.getTime());
                System.out.println("=====");
                
            } else if (command.equals("search")) {
                System.out.print("검색 키워드를 입력해주세요 : ");
                String keyword = sc.nextLine();
                System.out.println("=====");

                for(Post post : posts) {
                    if(post.getTitle().contains(keyword)) {
                        System.out.println("번호 : " + post.getId());
                        System.out.println("제목 : " + post.getTitle());
                    }
                }
            }
        }
    }
}