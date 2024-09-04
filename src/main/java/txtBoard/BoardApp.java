package txtBoard;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class BoardApp {

    ArrayList<Post> posts = new ArrayList<>();

    // 값의 초기화는 대부분 생성자에서 해주는 것을 권장합니다. 다양한 로직 수행 가능합니다.
    public BoardApp() {

        Post p1 = new Post(1, "안녕하세요 반갑습니다. java 공부중이에요.", "자바 너무 재밌어요!!", getCurrentDateTime(), 0);
        Post p2 = new Post(2, "java 질문좀 할게요~.", "냉무", getCurrentDateTime(), 0);
        Post p3 = new Post(3, "정처기 따야되나요?", "냉무", getCurrentDateTime(), 0);

        posts.add(p1);
        posts.add(p2);
        posts.add(p3);
    }

    public void run() {
        Scanner sc = new Scanner(System.in);

        int lastestId = 4;

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
                Post post = new Post(lastestId, title, body, getCurrentDateTime(), 0);
                posts.add(post);
                System.out.println("게시물이 등록되었습니다.");
                lastestId++;

            } else if (command.equals("list")) {
                printPostList(posts);

            } else if (command.equals("update")) {

                System.out.print("수정할 게시물 번호 : ");
                int targetId = Integer.parseInt(sc.nextLine());

                Post post = findPostById(targetId);

                if (post == null) {
                    System.out.println("없는 게시물 번호입니다.");
                    continue;
                }

                System.out.print("수정할 제목 : ");
                String newTitle = sc.nextLine();
                System.out.print("수정할 내용 : ");
                String newBody = sc.nextLine();

                post.setTitle(newTitle);
                post.setBody(newBody);
                System.out.println("수정이 완료되었습니다.");

            } else if (command.equals("delete")) {
                System.out.print("삭제할 게시물 번호 : ");
                int targetId = Integer.parseInt(sc.nextLine());
                Post post = findPostById(targetId);

                if (post == null) {
                    System.out.println("없는 게시물 번호입니다.");
                    continue;
                }

                posts.remove(post);
                System.out.println("삭제가 완료되었습니다.");

            } else if (command.equals("detail")) {

                System.out.print("상세보기 할 게시물 번호 : ");
                int targetId = Integer.parseInt(sc.nextLine());

                Post post = findPostById(targetId);

                if (post == null) {
                    System.out.println("없는 게시물 번호 입니다.");
                    continue;
                }
                post.increaseHit();

                System.out.printf("번호 : %d\n", post.getId());
                System.out.printf("제목 : %s\n", post.getTitle());
                System.out.printf("내용 : %s\n", post.getBody());
                System.out.printf("등록날짜 : %s\n", post.getCreateDate());
                System.out.printf("조회수 : %d\n", post.getHit());
                System.out.println("=============");

                while(true) {

                    System.out.print("상세보기 기능을 선택해주세요(1. 댓글 등록, 2. 추천, 3. 수정, 4. 삭제, 5. 목록으로) : ");
                    int function = Integer.parseInt(sc.nextLine());
                    if (function == 1) {
                        System.out.println("댓글 내용 : "                                                                        );
                    }
                    if (function == 2) {
                        System.out.println("[추천]");
                    }
                    if (function == 3) {
                        System.out.println("[수정]");
                    }
                    if (function == 4) {
                        System.out.println("[삭제]");
                    }
                    if (function == 5) {
                        System.out.println("상세보기 화면을 빠져나갑니다.");
                        break;
                    }
                }

                //1. 댓글 작성 그리고 그이후에 바로 나오는 댓글이 성공적으로 등록되었습니다.
                //2. 등록된 후 1번 게시글이 나오는 것과 그리고 댓글과 작성일(날짜,시간)이 나오는 것
                //3. 댓글 여러개 달기

            } else if (command.equals("search")) {
                System.out.print("검색 키워드 : ");
                String keyword = sc.nextLine();

                ArrayList<Post> searchedPostList = new ArrayList<>();

                for(Post post : posts) {
                    if(post.getTitle().contains(keyword)) {
                        searchedPostList.add(post);
                    }
                }



                printPostList(searchedPostList);
            }
        }
    }

    public Post findPostById(int id) {

        for (Post post : posts) {
            if (post.getId() == id) {
                return post;
            }
        }

        return null;
    }

    public String getCurrentDateTime() {

        // 현재 날짜와 시간 가져오기
        LocalDateTime currentDateTime = LocalDateTime.now();
        // 원하는 포맷 지정하기
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
        // 포맷 적용하여 출력하기
        String formattedDateTime = currentDateTime.format(formatter);

        return formattedDateTime;

    }

    public void printPostList(ArrayList<Post> targetList) {
        System.out.println("==================");
        for (Post post : targetList) {
            System.out.printf("번호 : %d\n", post.getId());
            System.out.printf("제목 : %s\n", post.getTitle());
            System.out.println("작성자 : hong");
            System.out.println("==================");
        }
    }
}