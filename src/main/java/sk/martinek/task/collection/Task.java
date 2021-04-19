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

    public void setId(ObjectId id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

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

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", priority=" + priority +
                ", done=" + done +
                ", date=" + date + (price>=0 ? ", price=" + price:" ");

    }
}
