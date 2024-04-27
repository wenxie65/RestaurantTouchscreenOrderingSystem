package org.sg.restaurant.dto;

public class House {
    private int houseId;
    private String houseNumber;
    private String aptNumber;
    private int streetId;

    public House() {
        houseId = -1;
        houseNumber = "";
        aptNumber = "";
        streetId = -1;
    }

    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getAptNumber() {
        return aptNumber;
    }

    public void setAptNumber(String aptNumber) {
        this.aptNumber = aptNumber;
    }

    public int getStreetId() {
        return streetId;
    }

    public void setStreetId(int streetId) {
        this.streetId = streetId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null ||
            this.getClass() != obj.getClass()) {
            return false;
        }

        House house = (House) obj;

        return (this.houseId == house.houseId &&
                this.houseNumber.equals(house.houseNumber) &&
                this.aptNumber.equals(house.aptNumber) &&
                this.streetId == house.streetId);
    }
}
