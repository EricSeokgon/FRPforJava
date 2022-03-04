package chapter2;

import nz.sodium.Cell;
import swidgets.src.swidgets.SLabel;
import swidgets.src.swidgets.STextField;

import javax.swing.*;
import java.awt.*;

public class add {
    public static void main(String[] args) {
        JFrame frame = new JFrame("add");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        STextField txtA = new STextField("5");
        STextField txtB = new STextField("10");
        Cell<Integer> a = txtA.text.map(t -> parseInt(t));
        Cell<Integer> b = txtB.text.map(t -> parseInt(t));
        Cell<Integer> sum = a.lift(b, (a_, b_) -> a_ + b_);
        SLabel lblsum = new SLabel(sum.map(i -> Integer.toString(i)));
        frame.add(txtA);
        frame.add(txtB);
        frame.add(lblsum);
        frame.setSize(400, 160);
        frame.setVisible(true);
    }

    private static Integer parseInt(String t) {

        try {
            return Integer.parseInt(t);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

}
