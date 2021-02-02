package lxt.project.myapplication.model.socket.param;

public class ForceSignOutParam extends BaseSocketParam  {
    public String id_business;
    public String type;

    public ForceSignOutParam(String id_business, String type) {
        this.id_business = id_business;
        this.type = type;
    }
}
