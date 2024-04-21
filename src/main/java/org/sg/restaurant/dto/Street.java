package org.sg.restaurant.dto;

public class Street {

    private int streetId;
    private String streetName;
    private String zipcode;

    public int getStreetId() {
        return streetId;
    }

    public void setStreetId(int streetId) {
        this.streetId = streetId;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
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

        Street street = (Street) obj;

        return (this.streetId == street.streetId &&
                this.streetName.equals(street.streetName) &&
                this.zipcode.equals(street.zipcode));
    }
}
