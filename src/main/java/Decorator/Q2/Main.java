package Decorator.Q2;


import Decorator.A2.Display;
import Decorator.A2.FullBorder;
import Decorator.A2.MultiStringDisplay;
import Decorator.A2.SideBorder;

public class Main {
    public static void main(String[] args) {
        MultiStringDisplay md = new MultiStringDisplay();
        md.add("早上好。");
        md.add("下午好。");
        md.add("晚安，明天见。");
        md.show();

        Display d1 = new SideBorder(md, '#');
        d1.show();

        Display d2 = new FullBorder(md);
        d2.show();
    }
}
