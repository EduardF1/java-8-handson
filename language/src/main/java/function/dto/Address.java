package function.dto;

import java.util.Objects;

public class Address {
    private String block;
    private String city;
    private String state;
    private String country;
    private int zipCode;

    public Address(String block, String city, String state, String country, int zipCode) {
        this.block = block;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return zipCode == address.zipCode && block.equals(address.block) && city.equals(address.city) && state.equals(address.state) && country.equals(address.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(block, city, state, country, zipCode);
    }

    @Override
    public String toString() {
        return "Address{" +
                "block='" + block + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", zipCode=" + zipCode +
                '}';
    }
}
