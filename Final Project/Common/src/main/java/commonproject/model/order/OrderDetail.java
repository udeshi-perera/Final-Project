package commonproject.model.order;


import commonproject.enumorator.Status;
import commonproject.model.menu.Menu;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "orderDetail")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Enumerated(EnumType.STRING)
    private Status status;

    @NotNull
    private int menu;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "orderId")
    @NotNull
    private int orderId;

    @NotNull
    private int quantity;

    @NotNull
    private float price;

    //private int menuId;
}
