package Visitor.A2;

import Visitor.A3.File;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Making root entries...");
            Directory rootdir = new Directory("root");
            Directory bindir = new Directory("bin");
            Directory tmpdir = new Directory("tmp");
            Directory usrdir = new Directory("usr");
            rootdir.add(bindir);
            rootdir.add(tmpdir);
            rootdir.add(usrdir);
            bindir.add(new Visitor.A3.File("vi", 10000));
            bindir.add(new Visitor.A3.File("latex", 20000));
            rootdir.accept(new ListVisitor());              

            System.out.println("");
            System.out.println("Making user entries...");
            Directory yuki = new Directory("yuki");
            Directory hanako = new Directory("hanako");
            Directory tomura = new Directory("tomura");
            usrdir.add(yuki);
            usrdir.add(hanako);
            usrdir.add(tomura);
            yuki.add(new Visitor.A3.File("diary.html", 100));
            yuki.add(new Visitor.A3.File("Composite.java", 200));
            hanako.add(new Visitor.A3.File("memo.tex", 300));
            tomura.add(new Visitor.A3.File("game.doc", 400));
            tomura.add(new File("junk.mail", 500));
            rootdir.accept(new ListVisitor());              
        } catch (FileTreatmentException e) {
            e.printStackTrace();
        }
    }
}
