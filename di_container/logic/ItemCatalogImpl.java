package di_container.logic;

import di_container.annotation.Resource;

import java.util.List;

public class ItemCatalogImpl implements ItemCatalog {
    @Resource
    private ItemDao dao;

    public List<Item> getAll(){
        return dao.findAll();
    }
}
