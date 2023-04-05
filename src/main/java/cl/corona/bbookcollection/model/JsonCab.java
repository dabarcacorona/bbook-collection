package cl.corona.bbookcollection.model;

import java.util.List;

public class JsonCab {
    private String list_id = "COMPOS";
    private List<JsonDet> elements;


    public JsonCab() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        return "JsonCab{" +
                ", list_id='" + list_id + '\'' +
                ", elements=" + elements +
                '}';
    }

    public JsonCab(List<JsonDet> elements) {
        this.elements = elements;
    }

    public List<JsonDet> getElements() {
        return elements;
    }

    public void setElements(List<JsonDet> elements) {
        this.elements = elements;
    }
}
