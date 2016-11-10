import Portfolio.Security;

/**
 * Created by nanasemaru on 8/11/2016.
 */
public class SecurityMemento {
    Security security;

    public SecurityMemento(Security security) {
        this.security = security;
    }

    public Security getSecurity() {
        return security;
    }
}
