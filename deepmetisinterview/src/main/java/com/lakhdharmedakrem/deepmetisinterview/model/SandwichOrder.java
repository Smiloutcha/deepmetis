package com.lakhdharmedakrem.deepmetisinterview.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table
public class SandwichOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sandiwchOrderId;

    @ManyToOne
    @JoinColumn(name = "sandwich_id")
    private Sandwich sandwich;

    @Column(nullable = false)
    private int quantity ;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime creationDate ;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime updateDate ;


    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }


    public Long getSandiwchOrderId() {
        return sandiwchOrderId;
    }

    public void setSandiwchOrderId(Long sandiwchOrderId) {
        this.sandiwchOrderId = sandiwchOrderId;
    }

    public Sandwich getSandwich() {
        return sandwich;
    }

    public void setSandwich(Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
