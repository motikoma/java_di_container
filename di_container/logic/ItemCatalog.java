package di_container.logic;

import java.util.List;

public interface ItemCatalog {
    public static ItemCatalog getInstance(){
        return new ItemCatalogImpl();
    }
    public List<Item> getAll();
}
