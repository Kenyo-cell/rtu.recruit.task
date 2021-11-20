package rtu.recruit.entities;

import rtu.recruit.enums.Category;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "product_name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "cost", nullable = false)
    private double cost;

    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private Category category;

    public ProductEntity() {}

    public ProductEntity(long id, Date date, String name,
                         double cost, Category category) {
        this.id = id;
        this.date = date;
        this.name = name;
        this.cost = cost;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
