package chapter2;

import swidgets.src.swidgets.SLabel;
import swidgets.src.swidgets.STextField;

import javax.swing.*;
import java.awt.*;

public class label {
    public static void main(String[] args) {
        JFrame frame = new JFrame("label");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        STextField msg = new STextField("Hello");
        SLabel lbl = new SLabel(msg.text);
        frame.add(msg);
        frame.add(lbl);
        frame.setSize(400, 160);
        frame.setVisible(true);

    }
}
