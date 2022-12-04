package ptf.rs.eventApp.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ptf.rs.eventApp.models.entities.Category;
import ptf.rs.eventApp.models.in.CategoryIn;
import ptf.rs.eventApp.models.out.CategoryOut;
import ptf.rs.eventApp.repositories.CategoryRepository;
import ptf.rs.eventApp.services.CategoryService;

@Service
public class CategoryServiceImplementation implements CategoryService {

    @Autowired
    private CategoryRepository _CategoryRepository;

    @Override
    public List<CategoryOut> getAllCategories() {
        List<Category> categories = _CategoryRepository.findAll();
        List<CategoryOut> processedCategories = new ArrayList<CategoryOut>();
        for(Category category : categories) processedCategories.add(new CategoryOut(category));
        return processedCategories;
    }

    @Override
    public CategoryOut addNewCategory(CategoryIn categoryIn) {
        List<CategoryOut> addedCategorys = this.getAllCategories();
        Category temp;
        try {
            temp = new Category(categoryIn);
            for(CategoryOut Category : addedCategorys) if(Category.getName().equals(temp.getName())) throw new Exception("Lokacija vec postoji.");
            _CategoryRepository.save(temp);
            return new CategoryOut(temp);
        } catch(Exception e) {}
        return null;
    }
    
}
