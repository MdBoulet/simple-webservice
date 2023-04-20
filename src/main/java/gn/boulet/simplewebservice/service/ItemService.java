package gn.boulet.simplewebservice.service;

import gn.boulet.simplewebservice.exception.ItemNotFoundNotException;
import gn.boulet.simplewebservice.model.Item;
import gn.boulet.simplewebservice.repository.ItemRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;


    public Item addItem(Item item) {
        return itemRepository.save(item);
    }

    public List<Item> getItems() {
        return StreamSupport
                .stream(itemRepository.findAll().spliterator(), false)
                .toList();
    }

    public Item getItem(Long id) {
        return itemRepository.findById(id).orElseThrow(() -> new ItemNotFoundNotException(id));
    }

    public Item deleteItem(Long id) {
        Item item = getItem(id);
        itemRepository.delete(item);

        return item;
    }

    @Transactional
    public Item editItem(Long id, Item item) {
        Item item1 = getItem(id);
        item1.setSerialNumber(item.getSerialNumber());

        return item1;
    }
}
