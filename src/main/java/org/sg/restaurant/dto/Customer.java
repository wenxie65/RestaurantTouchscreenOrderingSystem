package org.sg.restaurant.dto;

public class Customer {
    private String phoneNumber;
    private String customerName;
    private String customerNotes;

    // Initial optional variables
    public Customer() {
        customerName = "";
        customerNotes = "";
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerNotes() {
        return customerNotes;
    }

    public void setCustomerNotes(String customerNotes) {
        this.customerNotes = customerNotes;
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

        Customer customer = (Customer) obj;

        return (this.phoneNumber.equals(customer.phoneNumber) &&
                this.customerName.equals(customer.customerName) &&
                this.customerNotes.equals(customer.customerNotes));

    }
}
