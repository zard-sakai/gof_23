package Composite.A2;

import Composite.Sample.Entry;

import java.util.Iterator;
import java.util.ArrayList;

public class Directory extends Composite.Sample.Entry {
    private String name;
    private ArrayList directory = new ArrayList();
    public Directory(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public int getSize() {
        int size = 0;
        Iterator it = directory.iterator();
        while (it.hasNext()) {
            Composite.Sample.Entry entry = (Composite.Sample.Entry)it.next();
            size += entry.getSize();
        }
        return size;
    }
    public Composite.Sample.Entry add(Composite.Sample.Entry entry) {
        directory.add(entry);
        entry.parent = this;                
        return this;
    }
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
        Iterator it = directory.iterator();
        while (it.hasNext()) {
            Composite.Sample.Entry entry = (Entry)it.next();
            entry.printList(prefix + "/" + name);
        }
    }
}
