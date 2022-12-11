package ptf.rs.eventApp.services;

import java.util.List;

import ptf.rs.eventApp.models.in.CategoryIn;
import ptf.rs.eventApp.models.out.CategoryOut;

public interface CategoryService {
    public List<CategoryOut> getAllCategories();
    public CategoryOut getCategoryById(int id);
    public CategoryOut addNewCategory(CategoryIn categoryIn);
}
