package kg.java.todolist.core.exceptions;

public class EntityDuplicateException extends Exception{
    public EntityDuplicateException() {
        super("entity exist");
    }
}
