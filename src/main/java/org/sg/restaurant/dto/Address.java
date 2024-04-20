package org.sg.restaurant.dto;

public class Address {
    private int addressId;
    private String houseNumber;
    private String aptNumber;
    private String streetName;
    private String townName;
    private String zipcode;
    private String stateAbbrev;

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
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

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getStateAbbrev() {
        return stateAbbrev;
    }

    public void setStateAbbrev(String stateAbbrev) {
        this.stateAbbrev = stateAbbrev;
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

        Address address = (Address) obj;
        return (this.houseNumber.equals(address.houseNumber) &&
                this.aptNumber.equals(address.aptNumber) &&
                this.streetName.equals(address.streetName) &&
                this.townName.equals(address.townName) &&
                this.zipcode.equals(address.zipcode) &&
                this.stateAbbrev.equals(address.stateAbbrev));
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
