package last.file;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonUtil {

    // 메서드 오버로딩 => 매개변수 모양만 다르면 동일한 이름의 메서드 여러개 만들기 가능
    public String toJsonString(Member member) {
        // Person 객체 생성

        // Jackson의 ObjectMapper 객체 생성
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // 객체를 JSON 문자열로 직렬화
            String jsonString = objectMapper.writeValueAsString(member);
            return jsonString;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String toJsonString(Post post) {
        // Person 객체 생성

        // Jackson의 ObjectMapper 객체 생성
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // 객체를 JSON 문자열로 직렬화
            String jsonString = objectMapper.writeValueAsString(post);
            return jsonString;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Post toPost(String jsonString) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            Post post = objectMapper.readValue(jsonString, Post.class);
            return post;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Member toMember(String jsonString) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            Member member = objectMapper.readValue(jsonString, Member.class);
            return member;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}