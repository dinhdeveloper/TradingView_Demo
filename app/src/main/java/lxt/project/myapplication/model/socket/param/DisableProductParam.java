package lxt.project.myapplication.model.socket.param;

public class DisableProductParam extends BaseSocketParam {
    public String id_business;
    public String id_product;
    public String token;

    public DisableProductParam(String id_business, String id_product,String token) {
        this.id_business = id_business;
        this.id_product = id_product;
        this.token = token;
    }
}
