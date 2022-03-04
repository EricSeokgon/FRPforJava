package chapter2;

import nz.sodium.Stream;
import swidgets.src.swidgets.SButton;
import swidgets.src.swidgets.STextField;

import javax.swing.*;
import java.awt.*;

public class clearfield {
    public static void main(String[] args) {
        JFrame frame = new JFrame("clearfield");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        SButton clear = new SButton("Clear");
        Stream<String> sClearIt = clear.sClicked.map(u -> "");
        STextField text = new STextField(sClearIt, "Helloe");

        frame.add(text);
        frame.add(clear);
        frame.setSize(400, 160);
        frame.setVisible(true);

    }
}
