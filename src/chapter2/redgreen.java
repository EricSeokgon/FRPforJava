package chapter2;

import nz.sodium.Cell;
import nz.sodium.Stream;
import swidgets.src.swidgets.SButton;
import swidgets.src.swidgets.SLabel;

import javax.swing.*;
import java.awt.*;

public class redgreen {
    public static void main(String[] args) {
        JFrame frame = new JFrame("redfreen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        SButton red = new SButton("red");
        SButton green = new SButton("green");
        Stream<String> sRed = red.sClicked.map(u -> "red");
        Stream<String> sRGreen = green.sClicked.map(u -> "green");
        Stream<String> sColor = sRed.orElse(sRGreen);
        Cell<String> Color = sColor.hold("");
        SLabel lbl = new SLabel(Color);
        frame.add(red);
        frame.add(green);
        frame.add(lbl);
        frame.setSize(400, 160
        );
        frame.setVisible(true);

    }
}
