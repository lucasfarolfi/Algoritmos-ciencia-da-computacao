package org.example.prototypeWithBuilder;

public class Address implements Cloneable {
    private String street;
    private Integer number;

    public Address(String street, Integer number) {
        this.street = street;
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", number=" + number +
                '}';
    }

    @Override
    public Address clone() throws CloneNotSupportedException {
        return (Address) super.clone();
    }

    public Builder cloneBuilder(){
        return new Builder(street, number);
    }

    public static class Builder{
        private String street;
        private Integer number;

        public Builder(String street, Integer number) {
            this.street = street;
            this.number = number;
        }

        public Builder street(String street){
            this.street = street;
            return this;
        }

        public Builder number(Integer number){
            this.number = number;
            return this;
        }

        public Address get(){
            return new Address(street, number);
        }
    }
}
