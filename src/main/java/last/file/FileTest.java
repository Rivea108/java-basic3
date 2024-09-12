package last.file;

public class FileTest {
    public static void main(String[] args) {



        // 자바의 대부분의 정보는 객체라는 형태로 구조화(얼려져)되어 있다.
        // 파일은 기본적으로 텍스트로 저장된다.
        // 자바의 객체를 바로 텍스트로 저장 불가능.
        // 자바의 객체를 먼저 텍스트(문자)화 시켜야 함. => 직렬화(Serializalbe)
        // 텍스트를 불러와서 자바의 객체 형태로 만드는 것 => 역직렬화(Deserialzable)

        // 객체 직렬화 -> jackson 라이브러리를 이용해 객체를 json 문자화하기
        // int id, String title, String body, String createDate, int hit
        Post p1 = new Post(1, "aaa", "aaaa", "20240912", 0);

        FileUtil fu = new FileUtil();
        JsonUtil ju = new JsonUtil();

        String jsonString = ju.toJsonString(p1); // p1 객체를 json 문자열로 직렬화

        fu.save(jsonString, "test.json"); // 직렬화된 p1을 test.json 파일에 저장
        String content = fu.load("test.json");

        Post post = ju.toPost(content); // json 문자열을 Post로 객체화(역직렬화)

        Member m1 = new Member();
        m1.setLoginId("hong");
        m1.setLoginPw("1234");
        m1.setNickname("홍길동");

        String memberJson = ju.toJsonString(m1); // Member 직렬화
        fu.save(memberJson, "member.json");

        String memberContent = fu.load("member.json"); // 문자 => 객체.
        Member m2 = ju.toMember(memberContent);
        System.out.println(m2.getNickname());//역직렬화

    }

}