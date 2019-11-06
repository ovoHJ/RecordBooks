/*
    2302 강혜정
    프로젝트 '단(短)독'은 책을 전부 다 읽고 쓰는 기존의 독후감 방식과 다르게
    책을 읽을 때마다 조금씩 작성한 감상문을 합쳐 하나의 완성된 독후감이 만들어지는 프로그램입니다.
    프로그램을 실행하기 위해서는 RecordBookTest.java 파일에서 실행해야 합니다.

    'Menu.java'는 메뉴 화면을 관리하는 클래스입니다.
 */

import javax.swing.*;
import java.awt.*;

public class Menu {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    GridLayout gl = new GridLayout(3, 1);

    JButton allBook = new JButton("모든 독서");
    JButton endBook = new JButton("끝난 독서");
    JButton statistics = new JButton("독서 통계");
    Font font = new Font("맑은고딕", Font.BOLD, 16);

    public Menu() {

        allBook.setForeground(Color.WHITE);
        allBook.setBackground(new Color(79, 147, 255));
        endBook.setBackground(Color.WHITE);
        statistics.setBackground(Color.WHITE);

        panel.setLayout(gl);
        allBook.setFont(font);
        endBook.setFont(font);
        statistics.setFont(font);
        panel.add(allBook);
        panel.add(endBook);
        panel.add(statistics);
        frame.add(panel);

        frame.setResizable(false);
        frame.setLocation(2, 10);
        frame.setPreferredSize(new Dimension(70, 300));
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
