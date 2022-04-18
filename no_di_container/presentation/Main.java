package no_di_container.presentation;

import di_container.logic.ItemCatalog;

public class Main {
    public static void main(String[] args){
        ItemCatalog catalog = ItemCatalog.getInstance();
    }
}
