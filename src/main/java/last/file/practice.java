package last.file;

import com.fasterxml.jackson.databind.ObjectMapper;

public class practice {
    public static void main(String[] args) {

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            //Member member = new Member("loginId", "loginPw", "Nickname");

            //String JsonString = objectMapper.writeValueAsString(member);
           // System.out.println("JSON 문자열: " + JsonString);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    //return null;
}//챗 GPT보고 한 직렬화


