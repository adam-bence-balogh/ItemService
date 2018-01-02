package hu.abb.repository;

import hu.abb.entity.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * @author: Balogh Ádám Bence
 */
@Repository
public class InMemoryItemRepository implements ItemRepository{
    private static List<Item> itemList = new ArrayList<>();
    static{
        itemList.add(new Item(1L, "iPhone 6", 200));
        itemList.add(new Item(2L, "Ps 4", 350));
        itemList.add(new Item(3L, "Samsung Galaxy S6", 120));
    }

    @Override
    public List<Item> findAll() {
        return itemList;
    }

    @Override
    public Optional<Item> findById(long id) {
        return itemList.stream()
                .filter(item -> item.getId() == id)
                .findFirst();
    }
}
