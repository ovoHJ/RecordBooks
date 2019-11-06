/*
    2302 강혜정
    프로젝트 '단(短)독'은 책을 전부 다 읽고 쓰는 기존의 독후감 방식과 다르게
    책을 읽을 때마다 조금씩 작성한 감상문을 합쳐 하나의 완성된 독후감이 만들어지는 프로그램입니다.
    프로그램을 실행하기 위해서는 RecordBookTest.java 파일에서 실행해야 합니다.

    'EndBook.java'는 - 클래스입니다.
 */

import javax.swing.*;
import java.awt.*;

public class EndBook{
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();

    public EndBook() {
        panel.setBackground(Color.lightGray);

        frame.add(panel);

        frame.setResizable(false);
        frame.setPreferredSize(new Dimension(1200, 800));
        frame.setLocation(130, 10);
        frame.pack();
        frame.setVisible(true);
    }
}
