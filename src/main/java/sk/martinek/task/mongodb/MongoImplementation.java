package sk.martinek.task.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import sk.martinek.task.collection.Task;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
             MongoDatabase database = mongoClient.getDatabase("tskmngr");
             database.getCollection("tasks").insertOne(newTaskDoc);

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    public void setTrueTask(int id) {

    }

    public List<Task> getAllTasks() {


        try {  MongoClient mongoClient = new MongoClient();
            MongoDatabase database = mongoClient.getDatabase("testovanie");
            MongoCollection<Document> collec = database.getCollection("tasks");

            FindIterable<Document> cursor = collec.find();
            List<Task> list = new ArrayList<Task>();


            for (Document document : cursor) {
                System.out.println(document.toString());
                String name =  document.getString("name");
                int priority = document.getInteger("priority");
                Boolean done = document.getBoolean("done");
                Date date = (Date) document.getDate("date");
                ObjectId id = document.getObjectId("_id");
                Task task;

                if(document.containsKey("price")){
                    double price = document.getDouble("price");
                    task = new Task(name,priority,done,date,price);
                }else{
                    task = new Task(name,priority,done,date);

                }

                task.setId(id);
                list.add(task);
            }
            return list;
            //while (cursor.cursor().hasNext())
        }catch (Exception e){
            e.printStackTrace();
        }
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
