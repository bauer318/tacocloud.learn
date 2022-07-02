package ru.springinaction.first.tacocloud.tacos.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import ru.springinaction.first.tacocloud.tacos.TacoOrder;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {
    @PostMapping
    public String processOrder(TacoOrder order, SessionStatus sessionStatus){
        log.info("Order submitted : {}", order);
        sessionStatus.setComplete();
        return "redirect:/";
    }

    @GetMapping("/current")
    public String orderForm(){
        return "orderForm";
    }
}
