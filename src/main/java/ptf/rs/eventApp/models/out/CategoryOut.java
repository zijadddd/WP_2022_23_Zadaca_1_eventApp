package ptf.rs.eventApp.models.out;

import ptf.rs.eventApp.models.entities.Category;

public class CategoryOut {
    private Integer id;
    private String name;

    public CategoryOut() {
    }

    public CategoryOut(Category category) {
        this.id = category.getId();
        this.name = category.getName();
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    

    
}
