package com.arobs.ArobsMeetup.service.prize;

public class PrizeDTO {

    private int id;
    private String description;
    private int value;

    public PrizeDTO(int id, String description, int value) {
        this.id = id;
        this.description = description;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
