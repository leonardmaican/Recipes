package ro.siit.recipes.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The repository used to interact with the database
 */

@Repository
public interface RecipesRepository extends JpaRepository<Recipe, Long> {

    @Override
    List<Recipe> findAll();

    List<Recipe> findByCategoryOrderByDateCreated(Category category);


}
