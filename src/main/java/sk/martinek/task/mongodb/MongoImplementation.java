package sk.martinek.task.mongodb;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import jdk.nashorn.internal.parser.JSONParser;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.json.simple.JSONObject;
import sk.martinek.task.collection.Task;
import org.json.simple.parser.ParseException;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;


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

    //db.collec.find({done: "true"})
    public List<Task> getAllTasks(boolean done) {
        try {  MongoClient mongoClient = new MongoClient();
            MongoDatabase database = mongoClient.getDatabase("testovanie");
            MongoCollection<Document> collec = database.getCollection("tasks");


            FindIterable<Document> cursor = (FindIterable<Document>) collec.find(eq("done", done));

            List<Task> list = new ArrayList<Task>();

            for (Document document : cursor) {
                System.out.println(document.toString());
                String name =  document.getString("name");
                int priority = document.getInteger("priority");
                done = document.getBoolean("done");
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

    //db.collec.find({priority: "priorityNumber"})
    public List<Task> getAllTasksByPriority(int priorityNumber) {
        try {  MongoClient mongoClient = new MongoClient();
            MongoDatabase database = mongoClient.getDatabase("testovanie");
            MongoCollection<Document> collec = database.getCollection("tasks");


            FindIterable<Document> cursor = (FindIterable<Document>) collec.find(eq("priority", priorityNumber));

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

    //db.collec.find({name: "name"})
    public List<Task> getTaskByName(String name) {

        try {  MongoClient mongoClient = new MongoClient();
            MongoDatabase database = mongoClient.getDatabase("testovanie");
            MongoCollection<Document> collec = database.getCollection("tasks");


            FindIterable<Document> cursor = (FindIterable<Document>) collec.find(eq("name", name));

            List<Task> list = new ArrayList<Task>();

            for (Document document : cursor) {
                System.out.println(document.toString());
                name =  document.getString("name");
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

    //db.collec.find({date: "date"})
    public List<Task> getTaskByDate(Date date) {
        try {  MongoClient mongoClient = new MongoClient();
            MongoDatabase database = mongoClient.getDatabase("testovanie");
            MongoCollection<Document> collec = database.getCollection("tasks");


            FindIterable<Document> cursor = collec.find(eq("date", date));

            List<Task> list = new ArrayList<Task>();

            for (Document document : cursor) {
                System.out.println(document.toString());
                String name =  document.getString("name");
                int priority = document.getInteger("priority");
                Boolean done = document.getBoolean("done");
                date = (Date) document.getDate("date");
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

    public void deleteAllDoneTasks() {
        MongoClient mongoClient = new MongoClient();
        MongoDatabase database = mongoClient.getDatabase("testovanie");
        MongoCollection<Document> collec = database.getCollection("tasks");

        collec.deleteMany(new Document().append("done", true));
    }
}
