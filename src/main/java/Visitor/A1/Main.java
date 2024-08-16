package Visitor.A1;

import Visitor.A2.File;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        try {
            Directory rootdir = new Directory("root");
            Directory bindir = new Directory("bin");
            Directory tmpdir = new Directory("tmp");
            Directory usrdir = new Directory("usr");
            rootdir.add(bindir);
            rootdir.add(tmpdir);
            rootdir.add(usrdir);
            bindir.add(new Visitor.A2.File("vi", 10000));
            bindir.add(new Visitor.A2.File("latex", 20000));

            Directory yuki = new Directory("yuki");
            Directory hanako = new Directory("hanako");
            Directory tomura = new Directory("tomura");
            usrdir.add(yuki);
            usrdir.add(hanako);
            usrdir.add(tomura);
            yuki.add(new Visitor.A2.File("diary.html", 100));
            yuki.add(new Visitor.A2.File("Composite.java", 200));
            hanako.add(new Visitor.A2.File("memo.tex", 300));
            hanako.add(new Visitor.A2.File("index.html", 350));
            tomura.add(new Visitor.A2.File("game.doc", 400));
            tomura.add(new Visitor.A2.File("junk.mail", 500));

            FileFindVisitor ffv = new FileFindVisitor(".html");     
            rootdir.accept(ffv);                                    

            System.out.println("HTML files are:");
            Iterator it = ffv.getFoundFiles();                      
            while (it.hasNext()) {                                  
                Visitor.A2.File file = (File)it.next();
                System.out.println(file.toString());
            }                                                       
        } catch (FileTreatmentException e) {
            e.printStackTrace();
        }
    }
}
