
package CG.washer.GreenCarWash.model;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="Packs")
public class WashPacks {

    @Id
    String id;
    @NotEmpty(message = "Name Can't be empty")
    String name;
    @NotEmpty(message = "price Can't be empty")
    int cost;
    @NotEmpty(message = "Email Can't be empty")
    String description;

    //Default
    public WashPacks(){

    }

    //Constructor
    public WashPacks(String id, String name, int cost, String description) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.description = description;
    }

    //Getters and Setters
    public int getCost() {
        return cost;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "WashPacks{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", description='" + description + '\'' +
                '}';
    }

}