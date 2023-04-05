package cl.corona.bbookcollection.model;

public class JsonEnd {
    JsonCab data;

    public JsonEnd(JsonCab data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "JsonEnd{" +
                "data=" + data +
                '}';
    }

    public JsonCab getData() {
        return data;
    }

    public void setData(JsonCab data) {
        this.data = data;
    }
}
