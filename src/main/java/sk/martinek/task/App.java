package sk.martinek.task;

import com.mongodb.MongoClient;
import sk.martinek.task.collection.Task;
import sk.martinek.task.mongodb.MongoImplementation;

import java.util.Date;
import java.util.List;

public class App {
    public static void main(String[] args) {
        testAddNewTask();
        //testPrintAllTasks();
    }

    private static void testPrintAllTasks() {
        MongoImplementation mngompl = new MongoImplementation();
        List<Task> list = mngompl.getAllTasks();
        for(Task t: list){
            System.out.println(t.toString());
        }
    }


    public static void testAddNewTask(){
        Task task = new Task("readBook",2,false,new Date(),10.99);
        MongoImplementation mongo = new MongoImplementation();
        mongo.insertTask(task);

    }
}
