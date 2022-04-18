package di_container.logic;

import di_container.dataaccess.ItemDaoImpl;

import java.util.List;

public interface ItemDao {
    public static ItemDao getInstance(){
        return new ItemDaoImpl();
    }
    public List<Item> findAll();
}
