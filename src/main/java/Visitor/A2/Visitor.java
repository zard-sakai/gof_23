package Visitor.A2;

import Visitor.A3.File;

public abstract class Visitor {
    public abstract void visit(File file);
    public abstract void visit(Directory directory);
}
