package softuni.exam.models.entity;


import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "countries")
public class Country extends BaseEntity {

    @Column(name = "area")
    private double area;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "country")
    private Set<Attraction> attractions;

    @OneToMany(mappedBy = "countries")
    private Set<Visitor> visitor;

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Attraction> getAttractions() {
        return attractions;
    }

    public void setAttractions(Set<Attraction> attractions) {
        this.attractions = attractions;
    }

    public Set<Visitor> getVisitor() {
        return visitor;
    }

    public void setVisitor(Set<Visitor> visitor) {
        this.visitor = visitor;
    }
}
