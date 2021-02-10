package commonproject.model.order;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "newOrder")
public class Order {

    @Id
    @GeneratedValue
    private int id;

    private String orderDateTime;
}
