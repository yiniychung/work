import java.util.Vector;

/**
 * Created by nanasemaru on 2/11/2016.
 */
public abstract class Factory {
    public abstract void setRecord(Vector record);
    public abstract Command create();
}
