package com.snekold.promo.model;

import jakarta.persistence.*;



@Entity
@Table(name = "prize")
public class Prize {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nameWinner;
    private String number;
    private String email;

    @Column(nullable = false)
    private boolean status = false;

    @Column(nullable = false)
    private String cod;

    @Column( nullable = false)
    private String namePrize;

    @Column
    private String imagePath;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameWinner() {
        return nameWinner;
    }

    public void setNameWinner(String nameWinner) {
        this.nameWinner = nameWinner;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getNamePrize() {
        return namePrize;
    }

    public void setNamePrize(String namePrize) {
        this.namePrize = namePrize;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
