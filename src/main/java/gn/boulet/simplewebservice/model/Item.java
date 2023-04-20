package gn.boulet.simplewebservice.model;

import gn.boulet.simplewebservice.dto.ItemDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "item")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serialNumber;

    @ManyToOne
    private Cart cart;

    public static Item from(ItemDto itemDto) {
        return Item.builder()
                .serialNumber(itemDto.getSerialNumber())
                .build();
    }
}
