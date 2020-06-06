package com.sandlayth.fastfood.entity;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table
public class Product {
    @Id
    @GeneratedValue
    @Column()
    protected Long id;
    protected String name;
    @Lob
    protected byte[] picture;
    protected Boolean appearsInMenu;
    protected Boolean isABase;

    protected Product() {}

    protected Product(String name, Boolean appearsInMenu, Boolean isABase) {
        this.name = name;
        this.appearsInMenu = appearsInMenu;
        this.isABase = isABase;
    }

    protected Product(Long id, String name, byte[] picture, Boolean appearsInMenu, Boolean isABase) {
        this.id = id;
        this.name = name;
        this.picture = picture;
        this.appearsInMenu = appearsInMenu;
        this.isABase = isABase;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public Boolean getAppearsInMenu() {
        return appearsInMenu;
    }

    public void setAppearsInMenu(Boolean appearsInMenu) {
        this.appearsInMenu = appearsInMenu;
    }

    public Boolean getABase() {
        return isABase;
    }

    public void setABase(Boolean ABase) {
        isABase = ABase;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", picture=" + Arrays.toString(picture) +
                ", appearsInMenu=" + appearsInMenu +
                ", isABase=" + isABase +
                '}';
    }
}