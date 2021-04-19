package sk.martinek.task.collection;

import org.bson.types.ObjectId;

import java.util.Date;

public class Task {
    private ObjectId id;

    public Task(String name, int priority, boolean done, Date date) {
        this.name = name;
        this.priority = priority;
        this.done = done;
        this.date = date;
    }

    private String name;
    private int priority;

    public Task(String name, int priority, boolean done, Date date, Double price) {
        this(name, priority, done, date);
        this.price = price;
        id = null;
    }

    private boolean done;
    private Date date;

    public ObjectId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    public boolean isDone() {
        return done;
    }

    public Date getDate() {
        return date;
    }

    public Double getPrice() {
        return price;
    }

    private Double price;

}
