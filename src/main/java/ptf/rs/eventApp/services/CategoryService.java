package ptf.rs.eventApp.services;

import java.util.List;

import ptf.rs.eventApp.models.entities.Category;
import ptf.rs.eventApp.models.in.CategoryIn;
import ptf.rs.eventApp.models.out.CategoryOut;

public interface CategoryService {
    public List<CategoryOut> getAllCategories();
    public CategoryOut getCategoryById(int id);
    public Category getCategory(int id);
    public CategoryOut addNewCategory(CategoryIn categoryIn);
    public CategoryOut editCategory(CategoryIn categoryIn);
}
