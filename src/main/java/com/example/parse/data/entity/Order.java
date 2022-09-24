package com.example.parse.data.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Order implements Serializable {

  private static final long serialVersionUID = 7624968454314677205L;

  private Long orderId;
  private Double amount;
  private String currency;
  private String comment;
}
