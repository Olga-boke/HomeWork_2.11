package pro.sky.java.course2.homework_2_11.component;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import pro.sky.java.course2.homework_2_11.model.Item;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@Component
@SessionScope
public class Basket {

    private final Collection<Item> items;

    public Basket() {
        this.items = new ArrayList<>();
    }
    public void add(Collection<Item>items){
        this.items.addAll(items);
    }

    public Collection<Item> get(){
        return Collections.unmodifiableCollection(items);
    }
}
