package practicingPolymorphism;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame {

    JButton showBt;
    private JComboBox cb;
    JLabel lbl;
    String text = "Nothing selected yet  !";
    Frame () {
        JFrame f =  new JFrame();
        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        String lanuages[] = {"Java", "C", "Python", "CSS"};
        cb = new JComboBox(lanuages);
        cb.setBounds(20, 90, 30, 30);


        lbl = new JLabel(text);
        lbl.setBounds(20, 150, 150, 40);



        showBt = new JButton("show");
        showBt.setBounds(20, 20, 80, 50);
        f.add(cb);
        f.add(showBt);
        f.add(lbl);


        showBt.addActionListener(e -> {
            text = "selected text is: " + cb.getItemAt(cb.getSelectedIndex()).toString();

            lbl.setText(text);

        });

    }
}
