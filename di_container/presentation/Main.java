package di_container.presentation;

import di_container.core.Container;
import di_container.logic.Item;
import di_container.logic.ItemCatalog;
import di_container.logic.ItemCatalogImpl;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, ClassNotFoundException {

        Container container = new Container();
        ItemCatalog catalog = (ItemCatalog) container.getInstance(ItemCatalogImpl.class);

        List<Item> items = catalog.getAll();
        for (Item item : items) {
            System.out.println(item.getName());
        }
    }
}