package ru.springinaction.first.tacocloud.tacos;

import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;


import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class TacoOrder implements Serializable {
    private static  final   long    SerialVersionUID    =   1L;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private Date placedAt;

    @NotBlank(message="Delivery name is required")
    private String deliveryName;
    @NotBlank(message="Delivery street is required")
    private String deliveryStreet;
    @NotBlank(message="Delivery city is required")
    private String deliveryCity;
    @NotBlank(message="Delivery state is required")
    @Size(max=2,message="must two character for state")
    private String deliveryState;
    @NotBlank(message="Delivery Zip is required")
    private String deliveryZip;
    @CreditCardNumber(message="Not a valid credit card number")
    private String ccNumber;
    @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$",message = "Must be formatted MM/YY")
    private String ccExpiration;
    @Digits(integer=3, fraction=0,message="Invalid CVV")
    private String ccCVV;

    @OneToMany(cascade= CascadeType.ALL)
    private List<Taco> tacos = new ArrayList<>();

    public void addTaco(Taco taco){
        this.tacos.add(taco);
    }
}
