package lxt.project.myapplication.model.socket.param;

/**
 * Created by laixuantam on 12/7/16.
 */

public class ReloadTableDetailParam extends BaseSocketParam {
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

    public ReloadTableDetailParam(String id_business, String id_order, String id_floor, String id_table, String table_title, String table_status, String floor_type,String token) {
        this.id_business = id_business;
        this.id_order = id_order;
        this.id_floor = id_floor;
        this.id_table = id_table;
        this.table_title = table_title;
        this.table_status = table_status;
        this.type_manager = floor_type;
        this.token = token;
        type_prosessing = "add";
    }

    /**
     id_floor: '2',
     id_business: '1',
     id_order: '166',
     type_manager: 'eat-in',
     table_status: 'full',
     table_title: 'Bàn 9',
     id_table: '12',
     type_prosessing: 'update',
     total_table_on: '12',
     total_table_off: '8'

     */
}
