package cl.corona.bbookcollection.model;

public class JsonDet {

    private String elements_id;
    private String elements_name;

    public JsonDet(String elements_id, String elements_name) {
        super();
        this.elements_id = elements_id;
        this.elements_name = elements_name;
    }


    public String getVendor_id() {
        return elements_id;
    }

    public void setVendor_id(String elements_id) {
        this.elements_id = elements_id;
    }

    public String getVendor_name() {
        return elements_name;
    }

    public void setVendor_name(String elements_name) {
        this.elements_name = elements_name;
    }

}
