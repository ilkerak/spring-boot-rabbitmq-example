package com.example.rabbitmqexample.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "orders")
@Getter
@Setter
@ToString
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Username can not be null or empty.")
    private String username;

    @NotBlank(message = "Product can not be null or empty.")
    private String product;

    private Date date = new Date();

}
