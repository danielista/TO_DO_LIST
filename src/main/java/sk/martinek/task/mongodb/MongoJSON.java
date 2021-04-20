package sk.martinek.task.mongodb;

import org.json.simple.JSONObject;

public interface MongoJSON {
    public void insertTaskJSON(JSONObject task);
    public JSONObject getAllTasksInJSON();
}
