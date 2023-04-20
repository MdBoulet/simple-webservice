/*
package gn.boulet.simplewebservice.controller;

import gn.boulet.simplewebservice.dto.ItemDto;
import gn.boulet.simplewebservice.model.Item;
import gn.boulet.simplewebservice.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping
    public ResponseEntity<ItemDto> addItem(@RequestBody final ItemDto itemDto) {
        Item item = itemService.addItem(Item.from(itemDto));

        return new ResponseEntity<>(ItemDto.from(item), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ItemDto>> getItems() {
        List<Item> items = itemService.getItems();

        List<ItemDto> itemsDto = items.stream().map(ItemDto::from).collect(Collectors.toList());

        return new ResponseEntity<>(itemsDto, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<ItemDto> getItem(@PathVariable final Long id) {
        Item item = itemService.getItem(id);
        return new ResponseEntity<>(ItemDto.from(item), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ItemDto> deleteItem(@PathVariable Long id) {
        Item item = itemService.deleteItem(id);

        return new ResponseEntity<>(ItemDto.from(item), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<ItemDto> updateItem(@PathVariable Long id, @RequestBody ItemDto itemDto) {
        Item editItem = itemService.editItem(id, Item.from(itemDto));

        return new ResponseEntity<>(ItemDto.from(editItem), HttpStatus.OK);
    }
}
*/
