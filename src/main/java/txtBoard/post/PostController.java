package txtBoard.post;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class PostController {

    private PostRepository postRepository = new PostRepository();
    private PostView postView = new PostView();
    private Scanner sc = new Scanner(System.in);
    private int lastestId = 4;

    public PostController() {

        Post p1 = new Post(1, "안녕하세요 반갑습니다. java 공부중이에요.", "냉무", getCurrentDateTime(), 0);
        Post p2 = new Post(2, "java 질문좀 할게요~.", "냉무", getCurrentDateTime(), 0);
        Post p3 = new Post(3, "정처기 따야되나요?", "냉무", getCurrentDateTime(), 0);

        postRepository.save(p1);
        postRepository.save(p2);
        postRepository.save(p3);
    }

    // command : detail
    public void detail() {

        System.out.print("상세보기 할 게시물 번호 : ");

        int targetId = getParsedInt(sc.nextLine(), -1);

        if (targetId == -1) {
            return;
        }

        //try - catch는 최대한 사용하지 않는게 좋다.
        //몇가지 상황을 제외하고는 try - catch 사용안하고 if로 처리 다 가능함.

        Post post = postRepository.findPostById(targetId);  // 창고에서 꺼내서

        // ==== 요리를 한다음
        if (post == null) {
            System.out.println("없는 게시물 번호 입니다.");
            return;
        }
        post.increaseHit();
        // ======
        postView.printPostDetail(post); // 서빙한테 넘겨줌

    }

    // command : list
    public void list() {
        ArrayList<Post> posts = postRepository.getPosts();
        postView.printPostList(posts);
    }

    // command : search
    public void search() {
        System.out.print("검색 키워드 : ");
        String keyword = sc.nextLine();

        ArrayList<Post> searchedPostList = postRepository.getPostsByKeyword(keyword);
        postView.printPostList(searchedPostList);
    }

    // command : delete
    public void delete() {
        System.out.print("삭제할 게시물 번호 : ");
        int targetId = getParsedInt(sc.nextLine(), -1);

        if (targetId == -1) {
            return;
        }

        Post post = postRepository.findPostById(targetId);

        if (post == null) {
            System.out.println("없는 게시물 번호입니다.");
            return;
        }

        postRepository.delete(post);
        System.out.println("삭제가 완료되었습니다.");

    }

    // command : update
    public void update() {
        System.out.print("수정할 게시물 번호 : ");
        int targetId = getParsedInt(sc.nextLine(), -1);

        if (targetId == -1) {
            return;
        }


        Post post = postRepository.findPostById(targetId);

        if (post == null) {
            System.out.println("없는 게시물 번호입니다.");
            return;
        }

        System.out.print("수정할 제목 : ");
        String newTitle = sc.nextLine();
        System.out.print("수정할 내용 : ");
        String newBody = sc.nextLine();

        post.setTitle(newTitle);
        post.setBody(newBody);
        System.out.println("수정이 완료되었습니다.");
    }

    // command : add
    public void add() {
        System.out.print("게시물 제목을 입력해주세요 : ");
        String title = sc.nextLine();
        System.out.print("게시물 내용을 입력해주세요 : ");
        String body = sc.nextLine();
        Post post = new Post(lastestId, title, body, getCurrentDateTime(), 0);
        postRepository.save(post);
        System.out.println("게시물이 등록되었습니다.");
        lastestId++;
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

    public int getParsedInt(String value, int defaulValue) {
        try {
            int parsedInt = Integer.parseInt(value);
            return parsedInt;

            } catch (NumberFormatException e) {
            System.out.println("숫자만 입력하시오.");
             }
 return defaulValue;
        }
    }

