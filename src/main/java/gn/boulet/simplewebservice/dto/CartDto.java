package gn.boulet.simplewebservice.dto;

import gn.boulet.simplewebservice.model.Cart;
import gn.boulet.simplewebservice.model.Item;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class CartDto {
    private Long id;
    private String name;
    private List<Item> items = new ArrayList<>();

    public static CartDto from(Cart cart) {
        return CartDto.builder()
                .id(cart.getId())
                .name(cart.getName())
                .items(cart.getItems())
                .build();
    }
}
