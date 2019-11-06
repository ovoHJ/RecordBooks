/*
    2302 강혜정
    프로젝트 '단(短)독'은 책을 전부 다 읽고 쓰는 기존의 독후감 방식과 다르게
    책을 읽을 때마다 조금씩 작성한 감상문을 합쳐 하나의 완성된 독후감이 만들어지는 프로그램입니다.
    프로그램을 실행하기 위해서는 RecordBookTest.java 파일에서 실행해야 합니다.

    'RecordBookTest.java'는 모든 파일을 관리하는 클래스입니다.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecordBookTest {
        static AllBook all = new AllBook();
        static EndBook end = null;
        static Statistics stat = null;
    public static void main(String[] args) {
        Menu menu = new Menu();

        /* 각각의 버튼을 클릭하면? */
        menu.allBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.allBook.setForeground(Color.WHITE);
                menu.endBook.setForeground(Color.BLACK);
                menu.statistics.setForeground(Color.BLACK);

                menu.allBook.setBackground(new Color(51, 153, 255));
                menu.endBook.setBackground(Color.WHITE);
                menu.statistics.setBackground(Color.WHITE);

                /* 화면을 확인해서 같은 화면이면 그대로, 다른 화면이면 본래 frame 창을 닫고 새로운 화면을 보여준다 */
                if (all != null) all.frame.dispose();
                if (end != null) end.frame.dispose();
                if (stat != null) stat.frame.dispose();

                all = new AllBook();
            }
        });
        menu.endBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.allBook.setForeground(Color.BLACK);
                menu.endBook.setForeground(Color.WHITE);
                menu.statistics.setForeground(Color.BLACK);

                menu.allBook.setBackground(Color.WHITE);
                menu.endBook.setBackground(new Color(51, 153, 255));
                menu.statistics.setBackground(Color.WHITE);

                /* 화면을 확인해서 같은 화면이면 그대로, 다른 화면이면 본래 frame 창을 닫고 새로운 화면을 보여준다 */
                if (all != null) all.frame.dispose();
                if (end != null) end.frame.dispose();
                if (stat != null) stat.frame.dispose();

                end = new EndBook();
            }
        });
        menu.statistics.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.allBook.setForeground(Color.BLACK);
                menu.endBook.setForeground(Color.BLACK);
                menu.statistics.setForeground(Color.WHITE);


                menu.allBook.setBackground(Color.WHITE);
                menu.endBook.setBackground(Color.WHITE);
                menu.statistics.setBackground(new Color(51, 153, 255));

                /* 화면을 확인해서 같은 화면이면 그대로, 다른 화면이면 본래 frame 창을 닫고 새로운 화면을 보여준다 */
                if (all != null) all.frame.dispose();
                if (end != null) end.frame.dispose();
                if (stat != null) stat.frame.dispose();

                stat = new Statistics();
            }
        });
    }
}
