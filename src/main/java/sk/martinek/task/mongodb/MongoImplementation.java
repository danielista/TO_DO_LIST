package sk.martinek.task.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.sun.org.apache.xerces.internal.dom.DocumentImpl;
import org.bson.Document;
import sk.martinek.task.collection.Task;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

public class MongoImplementation implements Mongosdatabase {

    // dbname: tskmngr
    // collection: tasks
    private static final MongoClient mongoClient = new MongoClient();
    private static final MongoDatabase ts = mongoClient.getDatabase("tskmngr");
    private static MongoCollection<Document> test;
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public void insertTask(Task task) {
        if(task==null){
            return;
        }
        Document newTaskDoc = new Document("name",task.getName()).
                append("priority",task.getPriority()).
                append("done",task.isDone()).
                append("date",task.getDate());

        if(task.getPrice() >= 0){
            newTaskDoc.append("price",task.getPrice());
        }
        if(task.getId() != null){
            newTaskDoc.append("_id",task.getId());
        }

        try{
             MongoClient mongoClient = new MongoClient();
             MongoDatabase database = mongoClient.getDatabase("testovanie");
             MongoCollection<Document> collec = database.getCollection("tasks");
             SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            collec.insertOne(newTaskDoc);

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    public void setTrueTask(int id) {

    }

    public List<Task> getAllTasks() {
        return null;
    }

    public List<Task> getAllTasks(boolean done) {
        return null;
    }

    public List<Task> getAllTasksByPriority(int priority) {
        return null;
    }

    public List<Task> getTaskByName(String name) {
        return null;
    }

    public List<Task> getTaskByDate(Date date) {
        return null;
    }

    public void deleteAllDoneTasks() {

    }
}
