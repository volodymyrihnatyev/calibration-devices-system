package com.softserve.edu.entity.catalogue;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Building {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String number;

    @ManyToOne
    private Street street;

    @OneToMany
    @JoinColumn(name = "building_id")
    private Set<Flat> flats;

    protected Building() {}

    public Building(String number, Set<Flat> flats) {
        this.number = number;
        this.flats = flats;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }

    public Set<Flat> getFlats() {
        return flats;
    }

    public void setFlats(Set<Flat> flats) {
        this.flats = flats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }

        if (o == null || getClass() != o.getClass()) { return false; }

        Building building = (Building) o;

        return new EqualsBuilder()
                .append(id, building.id)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "Building{" +
                "id=" + id +
                ", number='" + number + '\'' +
                '}';
    }
}