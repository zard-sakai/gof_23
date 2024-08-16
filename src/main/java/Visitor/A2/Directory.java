package Visitor.A2;

import Visitor.A3.Entry;

import java.util.Iterator;
import java.util.ArrayList;

public class Directory extends Visitor.A3.Entry {
    private String name;                    // 文件夹名字
    private ArrayList dir = new ArrayList();      // 目录条目的集合
    public Directory(String name) {         // 构造函数
        this.name = name;
    }
    public String getName() {               // 获取名字
        return name;
    }
    public int getSize() {                  // 获取大小
        SizeVisitor v = new SizeVisitor();  
        accept(v);                          
        return v.getSize();                 
    }
    public Visitor.A3.Entry add(Entry entry) {         // 添加目录条目
        dir.add(entry);
        return this;
    }
    public Iterator iterator() {
        return dir.iterator();
    }
    public void accept(Visitor.A3.Visitor v) {
        v.visit(this);
    }
}
