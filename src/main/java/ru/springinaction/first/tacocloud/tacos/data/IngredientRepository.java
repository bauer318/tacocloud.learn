package ru.springinaction.first.tacocloud.tacos.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import ru.springinaction.first.tacocloud.tacos.Ingredient;

import java.util.Optional;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}
