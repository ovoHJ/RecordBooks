/*
    2302 강혜정
    프로젝트 '단(短)독'은 책을 전부 다 읽고 쓰는 기존의 독후감 방식과 다르게
    책을 읽을 때마다 조금씩 작성한 감상문을 합쳐 하나의 완성된 독후감이 만들어지는 프로그램입니다.
    프로그램을 실행하기 위해서는 RecordBookTest.java 파일에서 실행해야 합니다.

    'CompleteBook.java'는 최종적으로 독후감을 수정할 수 있는 클래스입니다.
 */

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Vector;

public class CompleteBook {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JPanel inPanel = new JPanel();
    BorderLayout bl = new BorderLayout();
    JButton save = new JButton("저장하기");
    Font font = new Font("맑은고딕", Font.BOLD, 16);

    String title = null;
    String date = null;
    String writer = null;
    String publisher = null;
    String story = "";
    String feeling = "";
    String para = "";

    public CompleteBook(String title, String writer, String publisher) {
        String t1 = title;
        BookDB bodb = new BookDB();

        save.setBackground(new Color(51, 153, 255));
        save.setBackground(new Color(79, 147, 255));
        save.setForeground(Color.WHITE);
        save.setFont(font);

        panel.setLayout(bl);
        /* 정보를 전부 변수에 넣어 합쳤습니다. */
        Vector<Book> blist = bodb.search(title, writer, publisher);
        Book book = new Book();
        for (int i = 0 ; i < blist.size() ; i++) {
            book = blist.get(i);
            title = book.getTitle();
            if (i == 0) date = book.getDate() + " ~ ";
            else if (i == blist.size() - 1) date += book.getDate();
            writer = book.getWriter();
            publisher = book.getPublisher();
            story += book.getStory() + "\n";
            feeling += book.getFeeling() + "\n";
            para += book.getParagraph() + "\n";
        }

        Border border = BorderFactory.createLineBorder(Color.gray, 1);
        JLabel jtitle = new JLabel("제목 : ");
        JTextField tftitle = new JTextField(" ");
        tftitle.setPreferredSize(new Dimension(510, 30));
        JLabel jdate = new JLabel("날짜 : ");
        JTextField tfdate = new JTextField(" ");
        tfdate.setPreferredSize(new Dimension(510, 30));
        JLabel jwriter = new JLabel("작가 : ");
        JTextField tfwriter = new JTextField(" ");
        tfwriter.setPreferredSize(new Dimension(510, 30));
        JLabel jpublisher = new JLabel("출판사 : ");
        JTextField tfpublisher = new JTextField(" ");
        tfpublisher.setPreferredSize(new Dimension(499, 30));

        JLabel jstory = new JLabel("오늘 읽은 책 내용 :                                                                                                                                                    ");
        JTextArea tfstory = new JTextArea(" ");
        tfstory.setLineWrap(true);
        tfstory.setBorder(border);
        tfstory.setPreferredSize(new Dimension(545, 220));
        JLabel jfeeling = new JLabel("오늘 읽은 책 감상 :                                                                                                                                                    ");
        JTextArea tffeeling = new JTextArea(" ");
        tffeeling.setLineWrap(true);
        tffeeling.setBorder(border);
        tffeeling.setPreferredSize(new Dimension(545, 155));
        JLabel jpara = new JLabel("오늘 읽은 책 속 인상 깊은 구절 :                                                                                                                                                    ");
        JTextArea tfparagraph = new JTextArea(" ");
        tfparagraph.setLineWrap(true);
        tfparagraph.setBorder(border);
        tfparagraph.setPreferredSize(new Dimension(545, 120));

        tftitle.setText(title);
        tfdate.setText(date);
        tfwriter.setText(writer);
        tfpublisher.setText(publisher);
        tfstory.setText(story);
        tffeeling.setText(feeling);
        tfparagraph.setText(para);

        inPanel.add(jtitle);
        inPanel.add(tftitle);
        inPanel.add(jdate);
        inPanel.add(tfdate);
        inPanel.add(jwriter);
        inPanel.add(tfwriter);
        inPanel.add(jpublisher);
        inPanel.add(tfpublisher);
        inPanel.add(jstory);
        inPanel.add(tfstory);
        inPanel.add(jfeeling);
        inPanel.add(tffeeling);
        inPanel.add(jpara);
        inPanel.add(tfparagraph);

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    BufferedWriter out = new BufferedWriter(new FileWriter("src/txt/" + t1 + ".txt"));
                    out.write("제목 : " + tftitle.getText() + "\n");
                    out.write("날짜 : " + tfdate.getText() + "\n");
                    out.write("작가 : " + tfwriter.getText() + "\n");
                    out.write("출판사 : " + tfpublisher.getText() + "\n");
                    out.newLine();
                    out.write("줄거리 : \n");
                    out.write(tfstory.getText());
                    out.newLine();
                    out.write("느낀 점 : \n");
                    out.write(tffeeling.getText());
                    out.newLine();
                    out.write("인상 깊은 구절 : \n");
                    out.write(tfparagraph.getText());
                    out.newLine();

                    out.close();
                } catch (Exception eee) {
                    eee.printStackTrace();
                }
            }
        });

        panel.add(inPanel);
        panel.add(save, BorderLayout.SOUTH);
        frame.add(panel);

        frame.setResizable(false);
        frame.setPreferredSize(new Dimension(600, 800));
        frame.setLocation(930, 10);
        frame.pack();
        frame.setVisible(true);
    }
}
