package ru.springinaction.first.tacocloud.tacos.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import ru.springinaction.first.tacocloud.tacos.TacoOrder;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {
    @PostMapping
    public String processOrder(@Valid TacoOrder order, Errors errors, SessionStatus sessionStatus){
        if(errors.hasErrors()){
            return "orderForm";
        }
        log.info("Order submitted : {}", order);
        sessionStatus.setComplete();
        return "redirect:/";
    }

    @GetMapping("/current")
    public String orderForm(){
        return "orderForm";
    }
}
