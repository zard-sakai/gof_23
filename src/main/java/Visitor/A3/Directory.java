package Visitor.A3;

import Visitor.Sample.Entry;

import java.util.Iterator;
import java.util.ArrayList;

public class Directory extends Visitor.Sample.Entry {
    private String name;                    // 文件夹名字
    private ArrayList dir = new ArrayList();      // 目录条目集合
    public Directory(String name) {         // 构造函数
        this.name = name;
    }
    public String getName() {               // 获取名字
        return name;
    }
    public int getSize() {                  // 获取大小
        int size = 0;
        Iterator it = dir.iterator();
        while (it.hasNext()) {
            Visitor.Sample.Entry entry = (Visitor.Sample.Entry)it.next();
            size += entry.getSize();
        }
        return size;
    }
    public Visitor.Sample.Entry add(Entry entry) {         // 增加目录条目
        dir.add(entry);
        return this;
    }
    public Iterator iterator() {      // 生成Iterator
        return dir.iterator();
    }
    public void accept(Visitor.Sample.Visitor v) {         // 接受访问者的访问
        v.visit(this);
    }
}
