package commonproject.model.menu;

import commonproject.enumorator.FoodCategory;
import commonproject.enumorator.Status;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "menu")
public class Menu {
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String code;

    @NotNull
    private String itemName;

    @Enumerated(EnumType.STRING)
    private FoodCategory foodCategory;

    @NotNull
    private float pricePerItem;
}
