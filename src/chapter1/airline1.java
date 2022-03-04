package chapter1;


import nz.sodium.Cell;
import swidgets.src.swidgets.SButton;
import swidgets.src.swidgets.SDateField;

import javax.swing.*;
import java.awt.*;

public class airline1 {
    public static void main(String[] args) {
        JFrame view = new JFrame("airline1");
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SDateField dep = new SDateField();
        SDateField ret = new SDateField();
        Cell<Boolean> valid = dep.date.lift(ret.date,
                (d, r) -> d.compareTo(r) <= 0);
        SButton ok = new SButton("OK", valid);

        GridBagLayout gridbag = new GridBagLayout();
        view.setLayout(gridbag);
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0.0;
        view.add(new JLabel("departure"), c);
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 1.0;
        view.add(dep, c);
        c.gridwidth = 1;
        c.gridheight = 1;
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 0.0;
        view.add(new JLabel("return"), c);
        c.gridx = 1;
        c.gridy = 1;
        c.weightx = 1.0;
        view.add(ret, c);
        c.fill = GridBagConstraints.NONE;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 2;
        c.weightx = 1.0;
        view.add(ok, c);
        view.setSize(380, 140);
        view.setVisible(true);

    }
}
