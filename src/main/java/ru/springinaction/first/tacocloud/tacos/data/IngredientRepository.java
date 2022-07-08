package ru.springinaction.first.tacocloud.tacos.data;

import ru.springinaction.first.tacocloud.tacos.Ingredient;

import java.util.Optional;

public interface IngredientRepository {
    Iterable<Ingredient> findAll();
    Optional<Ingredient> findById(String id);
    Ingredient save(Ingredient ingredient);
}
