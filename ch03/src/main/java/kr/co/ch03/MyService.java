package kr.co.ch03;

import org.springframework.stereotype.Component;

@Component
public class MyService {

    public void insert() {
        System.out.println("핵심기능 - Insert()");
    }
    public void select(String id) {
        System.out.println("핵심기능 - Select()");

        if(id.equals("a101")) {
            System.out.println("핵심기능 - Select(id) : " + id);
        }
    }
    public void update() {
        System.out.println("핵심기능 - Update()");
    }
    public void delete() {
        System.out.println("핵심기능 - Delete()");
    }
}
