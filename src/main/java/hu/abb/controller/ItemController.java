package hu.abb.controller;

import hu.abb.entity.Item;
import hu.abb.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author: Balogh Ádám Bence
 */
@RestController
@RequestMapping(("/item"))
public class ItemController {
    @Autowired
    private ItemService itemService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Item> findAll(){
        return itemService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Item> findById(@PathVariable("id") Long id){
        Optional<Item> mostExpensiveItemOptional = itemService.findById(id);
        if(mostExpensiveItemOptional.isPresent()){
            return new ResponseEntity<>(mostExpensiveItemOptional.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
