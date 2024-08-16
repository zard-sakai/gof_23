package Visitor.A3;

import Visitor.Sample.Element;

import java.util.ArrayList;
import java.util.Iterator;

class ElementArrayList extends ArrayList implements Visitor.Sample.Element {
    public void accept(Visitor.Sample.Visitor v) {
        Iterator it = iterator();
        while (it.hasNext()) {
            Visitor.Sample.Element e = (Element)it.next();
            e.accept(v);
        }
    }
}
