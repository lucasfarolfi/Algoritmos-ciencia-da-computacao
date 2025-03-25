package org.example;

import org.example.example.Person;
import org.example.example.PersonSamples;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Person> frames = new ArrayList<>();

    public static void animate() throws InterruptedException {
        System.out.println("***************************");
        System.out.println("* ");
        System.out.println("* Adjust your screen's height");
        System.out.println("* ");
        System.out.println("***************************");
        Thread.sleep(3000);
        for(Person frame : frames){
            frame.draw();
            Thread.sleep(500);
        }
        System.out.println("***************************");
        System.out.println("* ");
        System.out.println("* Finished");
        System.out.println("* ");
        System.out.println("***************************");
    }

    public static Person addLeft(Person p) throws CloneNotSupportedException {
        var person = (Person) p.clone();
        person.left();
        frames.add(person);
        return person;
    }

    public static Person addRight(Person p) throws CloneNotSupportedException {
        var person = (Person) p.clone();
        person.right();
        frames.add(person);
        return person;
    }


    public static void main(String[] args) throws CloneNotSupportedException, InterruptedException {
        var samples = new PersonSamples();
        var person = samples.get("stickMan");
        frames.add(person);
        person = addLeft(person);
        person = addLeft(person);
        person = addLeft(person);
        person = addRight(person);
        person = addRight(person);
        person = addRight(person);
        person = addRight(person);
        person = addRight(person);
        person = addRight(person);
        person = addRight(person);
        person = addLeft(person);
        person = addLeft(person);
        person = addLeft(person);
        person = addLeft(person);
        person = addLeft(person);

        animate();
    }
}