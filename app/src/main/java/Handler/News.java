package Handler;

/**
 * Created by ARG on 9/12/2017 - 12:33 PM
 */

public class News
{
    private String id;
    private String title;
    private String author;
    private String content;


    public String getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getContent() {
        return content;
    }


    public void setId(String id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setContent(String content) {
        this.content = content;
    }
}
