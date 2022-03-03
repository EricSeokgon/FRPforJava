package chapter1;

import java.util.ArrayList;
import java.util.List;

public class ListBox {
    public interface Listener {
        void itemSelected(int index);
    }

    private List<Listener> listeners = new ArrayList<>();

    public void addListener(Listener l) {
        listeners.add(l);
    }

    public void removeListener(Listener l) {
        listeners.remove(l);
    }

/*    protected void notifyItemSelected(int index) {
        for(l : listeners)  l.itemSelected(index);

    }*/
}
