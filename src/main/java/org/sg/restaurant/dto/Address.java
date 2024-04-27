package org.sg.restaurant.dto;

public class Address {

    private int houseId;
    private String houseNumber;
    private String aptNumber;
    private String streetName;
    private String townName;
    private String stateAbbrev;
    private String zipcode;

    public Address() {
        houseId = -1;
        houseNumber = "";
        aptNumber = "";
        streetName = "";
        townName = "";
        stateAbbrev = "";
        zipcode = "";
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

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public String getStateAbbrev() {
        return stateAbbrev;
    }

    public void setStateAbbrev(String stateAbbrev) {
        this.stateAbbrev = stateAbbrev;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public String toString() {
        if (aptNumber == null) {
            return String.format("%s %s \n" +
                            "%s, %s %s",
                    houseNumber, streetName,
                    townName, stateAbbrev, zipcode);
        } else {
            return String.format("%s %s \n" +
                            "%s \n" +
                            "%s, %s %s",
                    houseNumber, streetName,
                    aptNumber,
                    townName, stateAbbrev, zipcode);
        }
    }
}
