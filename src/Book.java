/*
    2302 강혜정
    프로젝트 '단(短)독'은 책을 전부 다 읽고 쓰는 기존의 독후감 방식과 다르게
    책을 읽을 때마다 조금씩 작성한 감상문을 합쳐 하나의 완성된 독후감이 만들어지는 프로그램입니다.
    프로그램을 실행하기 위해서는 RecordBookTest.java 파일에서 실행해야 합니다.
 */

public class Book {
    private int num;
    private String title;
    private String writer;
    private String publisher;
    private String date;
    private int page;
    private String story;
    private String feeling;
    private String paragraph;
    private int finish;

    public int getNum() { return num; }
    public void setNum(int num) { this.num = num; }
    public String getTitle() { return title; }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getWriter() {
        return writer;
    }
    public void setWriter(String writer) {
        this.writer = writer;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page = page;
    }
    public String getStory() { return story; }
    public void setStory(String story) {
        this.story = story;
    }
    public String getFeeling() {
        return feeling;
    }
    public void setFeeling(String feeling) {
        this.feeling = feeling;
    }
    public String getParagraph() {
        return paragraph;
    }
    public void setParagraph(String paragraph) {
        this.paragraph = paragraph;
    }
    public int getFinish() {
        return finish;
    }
    public void setFinish(int finish) {
        this.finish = finish;
    }
}
