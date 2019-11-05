import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {
    JPanel panel = new JPanel();
    GridLayout gl = null;

    JButton allBook = new JButton("모든 독서");
    JButton endBook = new JButton("끝난 독서");
    JButton statistics = new JButton("독서 통계");

    public Menu() {
        gl = new GridLayout(30, 1);

        allBook.setBackground(new Color(51, 153, 255));
        endBook.setBackground(Color.WHITE);
        statistics.setBackground(Color.WHITE);

        panel.setBackground(Color.BLACK);
        panel.setLayout(gl);
        panel.add(allBook);
        panel.add(endBook);
        panel.add(statistics);
    }
}
