package gn.boulet.simplewebservice.service;

import gn.boulet.simplewebservice.exception.CartNotFoundException;
import gn.boulet.simplewebservice.model.Cart;
import gn.boulet.simplewebservice.model.Item;
import gn.boulet.simplewebservice.repository.CartRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ItemService itemService;

    public Cart addCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public List<Cart> getCarts() {
        return StreamSupport
                .stream(cartRepository.findAll().spliterator(), false)
                .toList();
    }

    public Cart getCart(Long id) {
        return cartRepository.findById(id).orElseThrow(() ->
                new CartNotFoundException(id));
    }

    public Cart deleteCart(Long id) {
        Cart cart = getCart(id);
        cartRepository.delete(cart);

        return cart;
    }

    @Transactional
    public Cart editCart(Long id, Cart cart) {
        Cart cartToEdit = getCart(id);
        cartToEdit.setName(cart.getName());

        return cartToEdit;
    }

    @Transactional
    public Cart addItemToCart(Long cartId, Long itemId) {
        Cart cart = getCart(cartId);

        Item item = itemService.getItem(cartId);

        cart.addItem(item);

        return cart;
    }

    @Transactional
    public Cart removeItemToCart(Long cartId, Long itemId) {
        Cart cart = getCart(cartId);
        Item item = itemService.getItem(itemId);
        cart.removeItem(item);

        return cart;
    }
}
