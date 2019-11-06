/*
    2302 강혜정
    프로젝트 '단(短)독'은 책을 전부 다 읽고 쓰는 기존의 독후감 방식과 다르게
    책을 읽을 때마다 조금씩 작성한 감상문을 합쳐 하나의 완성된 독후감이 만들어지는 프로그램입니다.
    프로그램을 실행하기 위해서는 RecordBookTest.java 파일에서 실행해야 합니다.

    'AllBook.java'는 - 클래스입니다.
 */

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

public class AllBook {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    GridLayout gl1 = new GridLayout(1, 2);
    GridLayout gl2 = new GridLayout(3, 1);
    JPanel inPanel = new JPanel();
    Font font = new Font("맑은고딕", Font.BOLD, 16);

    public AllBook() {
        BookDB bodb = new BookDB();

        panel.setLayout(gl1);
        panel.setBackground(Color.WHITE);
        inPanel.setBackground(Color.white);

        String header[] = {"날짜", "제목", "페이지", "작가", "출판사", "완료"};
        DefaultTableModel model = new DefaultTableModel(header, 0);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);

        /* DB selectAll()을 이용해서 JTable 에 값을 넣는 작업입니다. */
        Vector<Book> blist = bodb.selectAll();
        Book book = new Book();
        for (int i = 0 ; i < blist.size() ; i++) {
            String[] rows = new String[6];
            book = blist.get(i);
            rows[0] = book.getDate();
            rows[1] = book.getTitle();
            rows[2] = Integer.toString(book.getPage());
            rows[3] = book.getWriter();
            rows[4] = book.getPublisher();
            if(book.getFinish() == 1) rows[5] = "완료";
            else rows[5] = " ";

            model.addRow(rows);
        }
        /* 테이블 셀 가운데 정렬하는 작업입니다. */
        DefaultTableCellRenderer tableCellRenderer = new DefaultTableCellRenderer();
        tableCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        TableColumnModel tableColumnModel = table.getColumnModel() ;
        for (int i = 0 ; i < tableColumnModel.getColumnCount(); i++) {
            tableColumnModel.getColumn(i).setCellRenderer(tableCellRenderer);
        }

        /* 엄청난 GUI 구간입니다. */
        String[] year = {"2019", "2020"};
        String[] month = new String[12];
        for(int i = 1 ; i <= 12 ; i++) {
            if (i <= 9) month[i - 1] = "0" + Integer.toString(i);
            else month[i - 1] = Integer.toString(i);
        }
        String[] day = new String[31];
        for(int i = 1 ; i <= 31 ; i++) {
            if (i <= 9) day[i - 1] = "0" + Integer.toString(i);
            else day[i - 1] = Integer.toString(i);
        }

        Border border = BorderFactory.createLineBorder(Color.gray, 1);
        JComboBox<String> cbyear = new JComboBox<String>(year);
        cbyear.setPreferredSize(new Dimension(180, 30));
        cbyear.setBackground(Color.white);
        JComboBox<String> cbmonth = new JComboBox<String>(month);
        cbmonth.setPreferredSize(new Dimension(180, 30));
        cbmonth.setBackground(Color.white);
        JComboBox<String> cbday = new JComboBox<String>(day);
        cbday.setPreferredSize(new Dimension(180, 30));
        cbday.setBackground(Color.white);
        JLabel title = new JLabel("제목 : ");
        JTextField tftitle = new JTextField(" ");
        tftitle.setPreferredSize(new Dimension(510, 30));
        JLabel writer = new JLabel("작가 : ");
        JTextField tfwriter = new JTextField(" ");
        tfwriter.setPreferredSize(new Dimension(510, 30));
        JLabel publisher = new JLabel("출판사 : ");
        JTextField tfpublisher = new JTextField(" ");
        tfpublisher.setPreferredSize(new Dimension(496, 30));
        JLabel page = new JLabel("읽은 페이지 : ");
        JLabel page1 = new JLabel("쪽까지                                                                                        ");
        JTextField tfpage = new JTextField("0");
        tfpage.setHorizontalAlignment(JTextField.RIGHT);
        tfpage.setPreferredSize(new Dimension(105, 30));
        JCheckBox cbfinish = new JCheckBox("완료");
        cbfinish.setBackground(Color.white);

        JLabel story = new JLabel("오늘 읽은 책 내용 :                                                                                                                                                    ");
        JTextArea tfstory = new JTextArea(" ");
        tfstory.setLineWrap(true);
        tfstory.setBorder(border);
        tfstory.setPreferredSize(new Dimension(545, 180));
        JLabel feeling = new JLabel("오늘 읽은 책 감상 :                                                                                                                                                    ");
        JTextArea tffeeling = new JTextArea(" ");
        tffeeling.setLineWrap(true);
        tffeeling.setBorder(border);
        tffeeling.setPreferredSize(new Dimension(545, 130));
        JLabel para = new JLabel("오늘 읽은 책 감상 :                                                                                                                                                    ");
        JTextArea tfparagraph = new JTextArea(" ");
        tfparagraph.setLineWrap(true);
        tfparagraph.setBorder(border);
        tfparagraph.setPreferredSize(new Dimension(545, 80));

        JButton save = new JButton("저장하기");
        save.setBackground(new Color(79, 147, 255));
        save.setForeground(Color.WHITE);
        save.setFont(font);
        save.setPreferredSize(new Dimension(545, 40));
        JButton load = new JButton("최근 읽은 도서 불러오기");
        load.setBackground(new Color(79, 147, 255));
        load.setForeground(Color.WHITE);
        load.setFont(font);
        load.setPreferredSize(new Dimension(545, 40));

        inPanel.add(cbyear);
        inPanel.add(cbmonth);
        inPanel.add(cbday);
        inPanel.add(title);
        inPanel.add(tftitle);
        inPanel.add(writer);
        inPanel.add(tfwriter);
        inPanel.add(publisher);
        inPanel.add(tfpublisher);
        inPanel.add(page);
        inPanel.add(tfpage);
        inPanel.add(page1);
        inPanel.add(cbfinish);
        inPanel.add(story);
        inPanel.add(tfstory);
        inPanel.add(feeling);
        inPanel.add(tffeeling);
        inPanel.add(para);
        inPanel.add(tfparagraph);
        inPanel.add(save);
        inPanel.add(load);
        /* 엄청난 GUI 구간이 끝났습니다. */

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Book book1 = new Book();
                book1.setNum(0);
                book1.setTitle(tftitle.getText());
                book1.setWriter(tfwriter.getText());
                book1.setPublisher(tfpublisher.getText());
                book1.setDate(cbyear.getSelectedItem().toString() + cbmonth.getSelectedItem().toString() + cbday.getSelectedItem().toString());
                book1.setPage(Integer.parseInt(tfpage.getText()));
                book1.setStory(tfstory.getText());
                book1.setFeeling(tfstory.getText());
                book1.setParagraph(tfparagraph.getText());
                if (cbfinish.isSelected() == false) book1.setFinish(0);
                else book1.setFinish(1);

                bodb.insertBook(book1);

                model.setNumRows(0);

                Vector<Book> blist1 = bodb.selectAll();
                Book book = new Book();
                for (int i = 0 ; i < blist1.size() ; i++) {
                    String[] rows = new String[6];
                    book = blist1.get(i);
                    rows[0] = book.getDate();
                    rows[1] = book.getTitle();
                    rows[2] = Integer.toString(book.getPage());
                    rows[3] = book.getWriter();
                    rows[4] = book.getPublisher();
                    if(book.getFinish() == 1) rows[5] = "완료";
                    else rows[5] = " ";

                    model.addRow(rows);
                }
                table.setModel(model);
            }
        });

        load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Book book1 = new Book();
                book1 = bodb.latelyBook();
                tftitle.setText(book1.getTitle());
                tfwriter.setText(book1.getWriter());
                tfpublisher.setText(book1.getPublisher());
                tfpage.setText(Integer.toString(book1.getPage()));
            }
        });


        panel.add(scrollPane);
        panel.add(inPanel);
        frame.add(panel);

        frame.setResizable(false);
        frame.setPreferredSize(new Dimension(1200, 800));
        frame.setLocation(130, 10);
        frame.pack();
        frame.setVisible(true);

    }
}
