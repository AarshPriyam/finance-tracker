package com.tracker.trackerapplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@Entity
public class Expense {
//    @Valid

    @Id
    private Integer id;

    @NotBlank(message = "Category can not be blank")
    private String category;
    @NotBlank(message = "Amount can not be blank")
    private int amount;
    @NotBlank(message = "Date can not be blank")
    private Date date;
}