package AbstractFactory.A2.tablefactory;


import AbstractFactory.A2.factory.Link;
import AbstractFactory.A2.factory.Page;
import AbstractFactory.A2.factory.Tray;
import FactoryMethod.A2.framework.Factory;
import FactoryMethod.A2.framework.Product;

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

    @Override
    protected Product createProduct(String owner) {
        return null;
    }

    @Override
    protected void registerProduct(Product product) {

    }
}
