package com.lakhdharmedakrem.deepmetisinterview.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;

@Entity
@Table
public class Sandwich {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sandwichId;

   @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
   private Collection<Ingredient> ingredients ;

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

    public Long getSandwichId() {
        return sandwichId;
    }

    public void setSandwichId(Long sandwichId) {
        this.sandwichId = sandwichId;
    }

    public Collection<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Collection<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
