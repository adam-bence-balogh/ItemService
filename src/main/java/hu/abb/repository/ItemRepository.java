package hu.abb.repository;

import hu.abb.entity.Item;

import java.util.List;
import java.util.Optional;

/**
 * @author: Balogh Ádám Bence
 */
public interface ItemRepository {
    List<Item> findAll();
    Optional<Item> findById(long id);
}
