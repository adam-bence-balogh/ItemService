package hu.abb.service;

import hu.abb.entity.Item;
import hu.abb.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * @author: Balogh Ádám Bence
 */
@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public List<Item> findAll(){
        return itemRepository.findAll();
    }

    public Optional<Item> findById(long id){
        return itemRepository.findById(id);
    }

    public Optional<Item> findMostExpensive(){
        return itemRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Item::getPrice).reversed())
                .findFirst();
    }
}
