package ru.springinaction.first.tacocloud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.springinaction.first.tacocloud.tacos.Ingredient;
import ru.springinaction.first.tacocloud.tacos.Type;
import ru.springinaction.first.tacocloud.tacos.data.IngredientRepository;

@SpringBootApplication
public class TacoCloudApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(TacoCloudApplication.class, args);
    }
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("home");
    }
    @Bean
    public CommandLineRunner dataLoader(IngredientRepository repo){
        return args->{
            repo.save(new Ingredient("FLTO","Flour Tortilla", Type.WRAP));
            repo.save(new Ingredient("COTO","Corn Tortilla",Type.WRAP));
            repo.save(new Ingredient("GRBF","Ground Beef", Type.PROTEIN));
            repo.save(new Ingredient("CARN","Carnitas", Type.PROTEIN));
            repo.save(new Ingredient("TMTO","Diced Tomatoes", Type.VEGGIES));
            repo.save(new Ingredient("LETC","Lettuce", Type.VEGGIES));
            repo.save(new Ingredient("CHED","Cheddar", Type.CHEESE));
            repo.save(new Ingredient("JACK","Monterrey Jack", Type.CHEESE));
            repo.save(new Ingredient("SLSA","Salsa", Type.SAUCE));
            repo.save(new Ingredient("SRCR","Sour Cream", Type.SAUCE));
        };
    }

}
