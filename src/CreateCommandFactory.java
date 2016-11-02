/**
 * Created by nanasemaru on 2/11/2016.
 */
public class CreateCommandFactory extends Factory {
    public Command create() {
        return new CreateCommand();
    }
}
