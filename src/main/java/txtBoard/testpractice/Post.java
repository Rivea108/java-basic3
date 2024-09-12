package txtBoard.testpractice;

public class Post {
private String title;
private String body;
private int id;
private String time;

public Post(String title, String body, int id, String time) {
 this.title = title;
 this.body = body;
 this.id = id;
 this.time = time;
}

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}