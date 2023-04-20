package gn.boulet.simplewebservice.controller;

import gn.boulet.simplewebservice.dto.CartDto;
import gn.boulet.simplewebservice.model.Cart;
import gn.boulet.simplewebservice.model.Item;
import gn.boulet.simplewebservice.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping
    public ResponseEntity<CartDto> addCart(@RequestBody CartDto cartDto) {
        Cart cart = cartService.addCart(Cart.from(cartDto));

        return new ResponseEntity<>(CartDto.from(cart), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CartDto>> getCarts() {
        List<Cart> carts = cartService.getCarts();
        List<CartDto> cartDtos = carts.stream().map(CartDto::from).collect(Collectors.toList());

        return new ResponseEntity<>(cartDtos, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<CartDto> getCart(@PathVariable Long id) {
        Cart cart = cartService.getCart(id);

        return new ResponseEntity<>(CartDto.from(cart), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<CartDto> deleteCart(@PathVariable Long id) {
        Cart cart = cartService.deleteCart(id);

        return new ResponseEntity<>(CartDto.from(cart), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<CartDto> editCart(@PathVariable Long id, @RequestBody CartDto cartDto) {
        Cart cart = cartService.editCart(id, Cart.from(cartDto));

        return new ResponseEntity<>(CartDto.from(cart), HttpStatus.OK);
    }

    @PostMapping("{cartId}/items/{itemId}/add")
    public ResponseEntity<CartDto> addItemToCart(@PathVariable Long cartId, @PathVariable Long itemId) {
        Cart cart = cartService.addItemToCart(cartId, itemId);

        return new ResponseEntity<>(CartDto.from(cart), HttpStatus.OK);
    }

    @DeleteMapping("{cartId}/items/{itemId}/add")
    public ResponseEntity<CartDto> removeItemFromCart(@PathVariable Long cartId, @PathVariable Long itemId) {
        Cart cart = cartService.removeItemToCart(cartId, itemId);

        return new ResponseEntity<>(CartDto.from(cart), HttpStatus.OK);
    }
}
