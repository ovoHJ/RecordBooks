/*
    2302 강혜정
    프로젝트 '단(短)독'은 책을 전부 다 읽고 쓰는 기존의 독후감 방식과 다르게
    책을 읽을 때마다 조금씩 작성한 감상문을 합쳐 하나의 완성된 독후감이 만들어지는 프로그램입니다.
    프로그램을 실행하기 위해서는 RecordBookTest.java 파일에서 실행해야 합니다.

    'BookDB.java'는 JDBC 연동 및 DB에 관련된 모든 것을 관리하는 클래스입니다.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class BookDB {
    String JDBC_DRIVER = "org.gjt.mm.mysql.Driver";
    final String JDBC_URL = "jdbc:mysql://localhost:3306/mydb";
    final String USER = "root";
    final String PASS = "mirim2";
    Connection conn = null;
    PreparedStatement pstmt = null;
    String sql = null;
    ResultSet rs = null;

    /* 생성자를 통해 JDBC 드라이버 로딩 */
    public BookDB() {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("드라이버 로딩 및 Connection 오류");
        }
    }

    /* 책 정보를 DB에 insert 하는 메소드 */
    public void insertBook(Book book) {
        int result = 0;
        try {
            sql = "insert into book values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, 0);
            pstmt.setString(2, book.getTitle());
            pstmt.setString(3, book.getWriter());
            pstmt.setString(4, book.getPublisher());
            pstmt.setString(5, book.getDate());
            pstmt.setInt(6, book.getPage());
            pstmt.setString(7, book.getStory());
            pstmt.setString(8, book.getFeeling());
            pstmt.setString(9, book.getParagraph());
            pstmt.setInt(10, book.getFinish());
            pstmt.executeUpdate();

            result = 1;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("InsertBook 오류");
        }
    }

    /* DB에서 모든 책 정보를 Vector에 저장하여 가져오는 메소드 */
    public Vector<Book> selectAll() {
        Vector<Book> blist = new Vector<Book>();
        Book book = null;

        try {
            sql = "select * from book";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                book = new Book();
                book.setNum(rs.getInt("num"));
                book.setTitle(rs.getString("title"));
                book.setWriter(rs.getString("writer"));
                book.setPublisher(rs.getString("publisher"));
                book.setDate(rs.getString("date"));
                book.setPage(rs.getInt("page"));
                book.setStory(rs.getString("story"));
                book.setFeeling(rs.getString("feeling"));
                book.setParagraph(rs.getString("paragraph"));
                book.setFinish(rs.getInt("finish"));
                blist.add(book);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("SelectAll 오류");
        }

        return blist;
    }

    /* DB에서 가장 최근 저장한 책 정보를 가져오는 메소드 */
    public Book latelyBook() {
        Book book = null;
        try {
            sql = "select * from book ORDER BY num DESC LIMIT 1";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                book = new Book();
                book.setNum(rs.getInt("num"));
                book.setTitle(rs.getString("title"));
                book.setWriter(rs.getString("writer"));
                book.setPublisher(rs.getString("publisher"));
                book.setDate(rs.getString("date"));
                book.setPage(rs.getInt("page"));
                book.setStory(rs.getString("story"));
                book.setFeeling(rs.getString("feeling"));
                book.setParagraph(rs.getString("paragraph"));
                book.setFinish(rs.getInt("finish"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("LatelyBook 오류");
        }
        return book;
    }

    /* DB에서 모든 책 정보를 Vector에 저장하여 가져오는 메소드 */
    public Vector<Book> finishedBook() {
        Vector<Book> flist = new Vector<Book>();
        Book book = null;

        try {
            sql = "SELECT DATE, title, writer, publisher FROM book WHERE finish = 1";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                book = new Book();
                book.setDate(rs.getString("date"));
                book.setTitle(rs.getString("title"));
                book.setWriter(rs.getString("writer"));
                book.setPublisher(rs.getString("publisher"));
                flist.add(book);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("finishedBook 오류");
        }

        return flist;
    }

    /*  조건에 해당하는 정보를 전부 저장해서 리턴하는 메소드 */
    public Vector<Book> search(String title, String writer, String publisher) {
        Vector<Book> flist = new Vector<Book>();
        Book book = null;

        try {
            sql = "SELECT * FROM book WHERE title = ? and writer = ? and publisher = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, title);
            pstmt.setString(2, writer);
            pstmt.setString(3, publisher);

            rs = pstmt.executeQuery();
            while (rs.next()) {
                book = new Book();
                book.setTitle(rs.getString("title"));
                book.setWriter(rs.getString("writer"));
                book.setPublisher(rs.getString("publisher"));
                book.setDate(rs.getString("date"));
                book.setStory(rs.getString("story"));
                book.setFeeling(rs.getString("feeling"));
                book.setParagraph(rs.getString("paragraph"));
                flist.add(book);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("search 오류");
        }

        return flist;
    }
}
