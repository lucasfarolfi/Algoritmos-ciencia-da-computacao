package org.example.prototypeWithBuilder;

public class User implements Cloneable {
    private String name;
    private Integer age;
    private Address address;

    public User(String name, Integer age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }

    @Override
    public User clone() throws CloneNotSupportedException {
        return (User) super.clone();
    }

    public Builder cloneBuilder(){
        return new Builder(name, age, address);
    }

    public static class Builder{
        private String name;
        private Integer age;
        private Address address;

        public Builder(String name, Integer age, Address address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder age(Integer age){
            this.age = age;
            return this;
        }

        public Builder address(Address address){
            this.address = address;
            return this;
        }

        public User get(){
            return new User(name, age, address);
        }
    }
}
