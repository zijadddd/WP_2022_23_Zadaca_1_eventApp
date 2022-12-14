package ptf.rs.eventApp.services.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ptf.rs.eventApp.models.entities.Category;
import ptf.rs.eventApp.models.in.CategoryIn;
import ptf.rs.eventApp.models.out.CategoryOut;
import ptf.rs.eventApp.models.out.EventOut;
import ptf.rs.eventApp.models.out.LocationOut;
import ptf.rs.eventApp.repositories.CategoryRepository;
import ptf.rs.eventApp.services.CategoryService;

@Service
public class CategoryServiceImplementation implements CategoryService {

    @Autowired
    private CategoryRepository _CategoryRepository;

    @Override
    public List<CategoryOut> getAllCategories() {
        List<Category> categories = _CategoryRepository.findAll();
        return categories.stream().map(CategoryOut::new).collect(Collectors.toList());
    }

    @Override
    public CategoryOut getCategoryById(int id) {
        try {
            if(_CategoryRepository.findById(id) == null) throw new Exception("Category did not found.");
            return new CategoryOut(_CategoryRepository.findById(id));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
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
