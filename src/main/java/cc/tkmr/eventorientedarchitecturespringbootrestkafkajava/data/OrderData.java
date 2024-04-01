package cc.tkmr.eventorientedarchitecturespringbootrestkafkajava.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data // Lombok. Getter, Setter
@AllArgsConstructor // Lombok. Constructor with arguments
@NoArgsConstructor // Lombok. Constructor without arguments
public class OrderData {

    private String id;
    private String productName;
    private BigDecimal price;
    private String description;


}
