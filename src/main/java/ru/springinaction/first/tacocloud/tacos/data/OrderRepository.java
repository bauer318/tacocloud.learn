package ru.springinaction.first.tacocloud.tacos.data;

import ru.springinaction.first.tacocloud.tacos.TacoOrder;

public interface OrderRepository {
    TacoOrder save(TacoOrder tacoOrder);
}
