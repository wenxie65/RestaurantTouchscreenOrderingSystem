package org.sg.restaurant.dto;

public class State {

    private String stateAbbrev;
    private String stateName;

    public String getStateAbbrev() {
        return stateAbbrev;
    }

    public void setStateAbbrev(String stateAbbrev) {
        this.stateAbbrev = stateAbbrev;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
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

        State state = (State) obj;

        return (this.stateAbbrev.equals(state.stateAbbrev) &&
                this.stateName.equals(state.stateName));
    }
}
