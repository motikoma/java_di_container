package no_di_container.logic;

import di_container.dataaccess.ItemDaoImpl;
import di_container.logic.Item;

import java.util.List;

public interface ItemDao {
    public static di_container.logic.ItemDao getInstance(){
        return new ItemDaoImpl();
    }
    public List<Item> findAll();
}
