package ru.springinaction.first.tacocloud.tacos.data;

import org.springframework.data.repository.CrudRepository;
import ru.springinaction.first.tacocloud.tacos.TacoOrder;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {

}
