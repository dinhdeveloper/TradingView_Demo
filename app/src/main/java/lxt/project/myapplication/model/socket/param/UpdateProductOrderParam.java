package lxt.project.myapplication.model.socket.param;

public class UpdateProductOrderParam extends BaseSocketParam {
    public String id_business;
    public String id_order;
    public String id_floor;
    public String id_table;
    public String table_title;
    public String table_status;
    public String type_manager;
    public String total_table_on;
    public String total_table_off;
    public String type_prosessing;
    public String token;

    public UpdateProductOrderParam(String id_business, String id_order, String id_floor, String id_table, String table_title,String floor_type,String token) {
        this.id_business = id_business;
        this.id_order = id_order;
        this.id_floor = id_floor;
        this.id_table = id_table;
        this.table_title = table_title;
        this.type_manager = floor_type;
        this.token = token;
        table_status = "full";
        type_prosessing = "update";
    }
}
