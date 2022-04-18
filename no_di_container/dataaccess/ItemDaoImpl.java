package no_di_container.dataaccess;

import di_container.logic.Item;
import di_container.logic.ItemDao;

import java.util.ArrayList;
import java.util.List;

public class ItemDaoImpl implements ItemDao {
    public List<Item> findAll(){
        List<Item> list = new ArrayList<Item>();
        list.add(new Item(100, "orange", 100));
        list.add(new Item(101, "banana", 80));
        list.add(new Item(102, "apple", 20));
        return list;
    }
}
