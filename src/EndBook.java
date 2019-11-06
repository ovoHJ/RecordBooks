/*
    2302 강혜정
    프로젝트 '단(短)독'은 책을 전부 다 읽고 쓰는 기존의 독후감 방식과 다르게
    책을 읽을 때마다 조금씩 작성한 감상문을 합쳐 하나의 완성된 독후감이 만들어지는 프로그램입니다.
    프로그램을 실행하기 위해서는 RecordBookTest.java 파일에서 실행해야 합니다.

    'EndBook.java'는 다 읽은 책 정보를 보여주는 클래스입니다.
 */

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Vector;

public class EndBook{
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JPanel p = new JPanel();
    JButton load = new JButton("불러오기");
    JButton copy = new JButton("파일열기");
    BorderLayout bl = new BorderLayout();
    GridLayout gl = new GridLayout(1, 2);
    Font font = new Font("맑은고딕", Font.BOLD, 16);

    String selectTitle;
    String selectWriter;
    String selectPublisher;

    public EndBook() {
        BookDB bodb = new BookDB();

        load.setBackground(new Color(51, 153, 255));
        load.setBackground(new Color(79, 147, 255));
        load.setForeground(Color.WHITE);
        load.setFont(font);
        copy.setBackground(new Color(51, 153, 255));
        copy.setBackground(new Color(79, 147, 255));
        copy.setForeground(Color.WHITE);
        copy.setFont(font);
        p.setLayout(gl);
        p.add(load);
        p.add(copy);
        panel.setLayout(bl);
        panel.add(p, BorderLayout.SOUTH);
        panel.setBackground(Color.white);

        String header[] = {"날짜", "제목", "작가", "출판사", "선택"};
        DefaultTableModel model = new DefaultTableModel(header, 0);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);

        /* 테이블 셀 가운데 정렬하는 작업입니다. */
        DefaultTableCellRenderer tableCellRenderer = new DefaultTableCellRenderer();
        tableCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        TableColumnModel tableColumnModel = table.getColumnModel() ;
        for (int i = 0 ; i < tableColumnModel.getColumnCount(); i++) {
            tableColumnModel.getColumn(i).setCellRenderer(tableCellRenderer);
        }

        /* 다 읽은 책을 DB finishedBook()을 이용해서 JTable 에 값을 넣는 작업입니다. */
        Vector<Book> flist = bodb.finishedBook();
        Book book = new Book();
        for (int i = 0 ; i < flist.size() ; i++) {
            String[] rows = new String[6];
            book = flist.get(i);
            rows[0] = book.getDate();
            rows[1] = book.getTitle();
            rows[2] = book.getWriter();
            rows[3] = book.getPublisher();
            rows[4] = "선택";

            model.addRow(rows);
        }
        table.setModel(model);

        /* 클릭한 row 에 대한 정보를 저장합니다. */
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                selectTitle = table.getValueAt(table.getSelectedRow(), 1).toString();
                selectWriter = table.getValueAt(table.getSelectedRow(), 2).toString();
                selectPublisher = table.getValueAt(table.getSelectedRow(), 3).toString();
            }
        });

        load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(selectTitle != null) {
                        new CompleteBook(selectTitle, selectWriter, selectPublisher);

                    }
                } catch (Exception ee) {
                    ee.printStackTrace();
                }

            }
        });

        /* col 과 버튼을 누르면 파일이 열린다. */
        copy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(selectTitle != null) {
                        File f = new File("src/txt/" + selectTitle + ".txt");
                        BufferedWriter out;
                        if (f.isFile()) Desktop.getDesktop().open(new File("src/txt/" + selectTitle + ".txt"));
                        else out = new BufferedWriter(new FileWriter("src/txt/" + selectTitle + ".txt"));

                    }
                } catch (Exception eee) {
                    eee.printStackTrace();
                }
            }
        });

        panel.add(scrollPane);
        frame.add(panel);

        frame.setResizable(false);
        frame.setPreferredSize(new Dimension(800, 800));
        frame.setLocation(130, 10);
        frame.pack();
        frame.setVisible(true);
    }
}
