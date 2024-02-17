package com.lakhdharmedakrem.deepmetisinterview.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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

    @CreationTimestamp
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime creationDate ;

    @UpdateTimestamp
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime updateDate ;

    @ManyToOne
    private ClientOrder clientOrder;

    public ClientOrder getClientOrder() {
        return clientOrder;
    }

    public void setClientOrder(ClientOrder clientOrder) {
        this.clientOrder = clientOrder;
    }

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
