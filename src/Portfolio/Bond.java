package Portfolio;

/**
 * Created by nanasemaru on 2/11/2016.
 */
public class Bond extends Security {
    private float yield;

    public Bond(String code, String name, float yield) {
        super(code, name);
        this.yield = yield;
    }

    public float getYield() {
        return yield;
    }

    public void setYield(float yield) {
        this.yield = yield;
    }
}
