package Visitor.A3;

import Visitor.Sample.File;

public abstract class Visitor {
    public abstract void visit(File file);
    public abstract void visit(Directory directory);
}
