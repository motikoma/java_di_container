package no_di_container.logic;

import di_container.logic.Item;
import di_container.logic.ItemCatalog;
import di_container.logic.ItemDao;

import java.util.List;

public class ItemCatalogImpl implements ItemCatalog {
    private ItemDao dao = ItemDao.getInstance();

    public List<Item> getAll(){
        return dao.findAll();
    }
}
