package chapter5;

import javax.lang.model.element.Element;
import java.util.HashSet;

public interface SelectionListener {
    void selected(Element e);

    void deselected(Element e);
}


public class CursorMonitor implements SelectionListener {
    private HashSet<Element> selectedElts = new HashSet();

    public void selected(Element e) {
        selectedElts.add(e);
        updateCursor(e);
    }

    @Override
    public void deselected(Element e) {

    }

    private void updateCursor(Element e) {
        selectedElts.remove(e);
        updateCursor(e);
    }

}

