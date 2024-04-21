package org.sg.restaurant.dto;

public class Town {

    private String zipcode;
    private String townName;
    private String stateAbbrev;

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return false;
        }
        if (obj == null ||
            this.getClass() != obj.getClass()) {
            return false;
        }

        Town town = (Town) obj;

        return (this.zipcode.equals(town.zipcode) &&
                this.townName.equals(town.townName) &&
                this.stateAbbrev.equals(town.stateAbbrev));
    }
}
