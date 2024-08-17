package AbstractFactory.Sample.tablefactory;

import AbstractFactory.Sample.factory.Factory;
import AbstractFactory.Sample.factory.Link;
import AbstractFactory.Sample.factory.Page;
import AbstractFactory.Sample.factory.Tray;

public class TableFactory extends Factory {
    public Link createLink(String caption, String url) {
        return new TableLink(caption, url);
    }
    public Tray createTray(String caption) {
        return new TableTray(caption);
    }
    public Page createPage(String title, String author) {
        return new TablePage(title, author);
    }
}
