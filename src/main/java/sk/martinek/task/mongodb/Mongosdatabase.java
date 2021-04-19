package sk.martinek.task.mongodb;

import sk.martinek.task.collection.Task;

import java.sql.Date;
import java.util.List;

/**
 * @author Daniel
 */
public interface Mongosdatabase {
    public void insertTask(Task task);

    //nastaví hodnotu tasku na TRUE
    public void setTrueTask(int id);


    //select tasks on specific data
    // all tasks
    public List<Task> getAllTasks();
    // only not-completed tasks
    public List<Task> getAllTasks(boolean done);
    // task due PRIORITY
    public List<Task> getAllTasksByPriority(int priority);
    // task by NAME of task
    public List<Task> getTaskByName(String name);
    // by date
    public List<Task> getTaskByDate(Date date);


    //delete Tasks?
    public void deleteAllDoneTasks();


}
