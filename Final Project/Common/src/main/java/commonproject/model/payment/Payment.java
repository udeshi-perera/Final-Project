package commonproject.model.payment;

import commonproject.model.order.OrderDetail;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private int orderId;

    private float fullPayment;
}
