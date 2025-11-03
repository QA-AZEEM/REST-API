package azt.rest_ful_api.response;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


public class ItemsListResponse {
	
	private String id;
    private String name;
    private Map<String, Object> data;

    // Constructors
    public ItemsListResponse() {}
    public ItemsListResponse(String id, String name, Map<String, Object> data) {
        this.id = id;
        this.name = name;
        this.data = data;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Map<String, Object> getData() { return data; }
    public void setData(Map<String, Object> data) { this.data = data; }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", data=" + data +
                '}';
    }
}
