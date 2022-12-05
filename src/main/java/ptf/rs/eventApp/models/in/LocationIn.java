package ptf.rs.eventApp.models.in;

import org.springframework.lang.Nullable;
import javax.validation.constraints.Size;

public class LocationIn {
    @Nullable
    private Integer id;

    @Size(max = 255)
    private String name;

    @Size(max = 1000)
    private String description;

    @Size(max = 1000)
    private String imgUrl;

    public LocationIn() {
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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    
}
