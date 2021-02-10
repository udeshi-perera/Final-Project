package commonproject.model.customer;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String customerName;

@Column(unique = true)
    private String mobileNumber;

    private String email;
}
