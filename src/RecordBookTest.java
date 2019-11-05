/*
    2302 강혜정
    프로젝트 '단(短)독'은 책을 전부 다 읽고 쓰는 기존의 독후감 방식과 다르게
    책을 읽을 때마다 조금씩 작성한 감상문을 합쳐 하나의 완성된 독후감이 만들어지는 프로그램입니다.
    프로그램을 실행하기 위해서는 RecordBookTest.java 파일에서 실행해야 합니다.

    이 프로젝트는
 */

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecordBookTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        BorderLayout bl = new BorderLayout();

        Menu menu = new Menu();
        MainScreen ms = new MainScreen();

        panel.setLayout(bl);
        panel.add(menu.panel, BorderLayout.EAST);
        panel.add(ms.panel);

        menu.allBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.allBook.setBackground(new Color(51, 153, 255));
                menu.endBook.setBackground(Color.WHITE);
                menu.statistics.setBackground(Color.WHITE);
                // MainScreen 에서 화면 바뀌는 메서드
            }
        });
        menu.endBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.allBook.setBackground(Color.WHITE);
                menu.endBook.setBackground(new Color(51, 153, 255));
                menu.statistics.setBackground(Color.WHITE);
                // MainScreen 에서 화면 바뀌는 메서드
            }
        });
        menu.statistics.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.allBook.setBackground(Color.WHITE);
                menu.endBook.setBackground(Color.WHITE);
                menu.statistics.setBackground(new Color(51, 153, 255));
                // MainScreen 에서 화면 바뀌는 메서드
            }
        });

        frame.add(panel);

        frame.setPreferredSize(new Dimension(1500, 1000));
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
