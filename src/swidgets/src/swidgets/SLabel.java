package swidgets.src.swidgets;

import nz.sodium.Cell;
import nz.sodium.Listener;
import nz.sodium.Operational;
import nz.sodium.Transaction;

import javax.swing.*;

public class SLabel extends JLabel
{
    public SLabel(Cell<String> text) {
        super("");
        l = Operational.updates(text).listen(t -> {
            if (SwingUtilities.isEventDispatchThread())
                setText(t);
            else
                SwingUtilities.invokeLater(() -> {
                    setText(t);
                });
        });
        // Set the text at the end of the transaction so SLabel works
        // with CellLoops.
        Transaction.post(
            () -> SwingUtilities.invokeLater(() -> {
                setText(text.sample());
            })
        );
    }

    private final Listener l;

    public void removeNotify() {
        l.unlisten();
        super.removeNotify();
    }
}

