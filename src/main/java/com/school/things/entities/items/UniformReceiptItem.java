package com.school.things.entities.items;

import com.school.things.entities.*;
import jakarta.persistence.*;

@Entity
public class UniformReceiptItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pants_id")
    private Pants pants;

    @ManyToOne
    @JoinColumn(name = "skirt_id")
    private Skirt skirt;

    @ManyToOne
    @JoinColumn(name = "shirt_id")
    private Shirt shirt;

    @ManyToOne
    @JoinColumn(name = "shorts_id")
    private Shorts shorts;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "receipt_id", nullable = false)
    private UniformReceipt uniformReceipt;

    // Геттеры и сеттеры

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pants getPants() {
        return pants;
    }

    public void setPants(Pants pants) {
        this.pants = pants;
    }

    public Skirt getSkirt() {
        return skirt;
    }

    public void setSkirt(Skirt skirt) {
        this.skirt = skirt;
    }

    public Shirt getShirt() {
        return shirt;
    }

    public void setShirt(Shirt shirt) {
        this.shirt = shirt;
    }

    public Shorts getShorts() {
        return shorts;
    }

    public void setShorts(Shorts shorts) {
        this.shorts = shorts;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public UniformReceipt getUniformReceipt() {
        return uniformReceipt;
    }

    public void setUniformReceipt(UniformReceipt uniformReceipt) {
        this.uniformReceipt = uniformReceipt;
    }
}
