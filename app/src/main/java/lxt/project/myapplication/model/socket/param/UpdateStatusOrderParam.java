package lxt.project.myapplication.model.socket.param;

public class UpdateStatusOrderParam extends BaseSocketParam {
    public String id_business;
    public String id_order;
    public String id_floor;
    public String id_table;
    public String table_title;
    public String table_status;
    public String type_manager;
    public String token;

    public UpdateStatusOrderParam(String id_business, String id_order, String id_floor, String id_table, String table_title, String floor_type,String token) {
        this.id_business = id_business;
        this.id_order = id_order;
        this.id_floor = id_floor;
        this.id_table = id_table;
        this.table_title = table_title;
        this.type_manager = floor_type;
        table_status = "full";
        this.token = token;
    }
}
