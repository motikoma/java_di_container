package no_di_container.logic;

import di_container.logic.ItemCatalogImpl;

public interface ItemCatalog {
    public static di_container.logic.ItemCatalog getInstance(){
        return new ItemCatalogImpl();
    }
}
