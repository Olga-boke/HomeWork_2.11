package pro.sky.java.course2.homework_2_11.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.homework_2_11.component.Basket;
import pro.sky.java.course2.homework_2_11.model.Item;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StoreService {
    private final Basket basket;
    private Map<Integer,Item> items;

    public StoreService(Basket basket) {
        this.basket = basket;
    }
    @PostConstruct
    public void init(){
        items = Map.of(
                1, new Item(1, "смартон", 40000),
                2, new Item(2, "комп", 80000),
                3, new Item(3, "принтер", 10000)
        );
    }

    public void add(List<Integer> ids) {
        basket.add(
                ids.stream()
                        .map(items::get)
                        .collect(Collectors.toList())
        );
    }

    public Collection<Item> get() {
        return basket.get();
    }
}
