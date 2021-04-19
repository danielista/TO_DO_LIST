package sk.martinek.task;

import com.mongodb.MongoClient;
import sk.martinek.task.collection.Task;
import sk.martinek.task.mongodb.MongoImplementation;

import java.util.Date;

public class App {
    public static void main(String[] args) {
        testAddNewTask();
    }




    public static void testAddNewTask(){
        Task task = new Task("readBook",2,false,new Date(),10.99);
        MongoImplementation mongo = new MongoImplementation();
        mongo.insertTask(task);

    }
}
