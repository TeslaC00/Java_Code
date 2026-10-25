// Sample.java
import java.util.Map;
import java.time.Instant;

public class Sample {

    private static Long sampleId = 0L;

    private Long id;
    private String name;
    private Instant time;
    private Integer count;
    private String category;
    private Boolean status;

    private Sample(){}

    public Sample(String name, Instant time, Integer count, String category){
        this.id = sampleId++;
        this.name = name;
        this.time = time;
        this.count = count;
        this.category = category;
        this.status = false;
    }

    public Sample(String name, Instant time, Integer count, String category, Boolean status){
        this.id = sampleId++;
        this.name = name;
        this.time = time;
        this.count = count;
        this.category = category;
        this.status = status;
    }

    public Sample update(String name, Integer count){
        if(name!=null && !name.isEmpty()) this.name = name;
        if(count!=null && count >= 0) this.count = count;
        return this;
    }

    public Sample update(Map<String,Object> body){
        String name = String.valueOf(body.get("name"));
        Integer count = Integer.parseInt(body.get("count").toString());
        if(name!=null && !name.isEmpty()) this.name = name;
        if(count!=null && count >= 0) this.count = count;
        return this;
    }

    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public Instant getTime(){
        return time;
    }

    public Integer getCount(){
        return count;
    }

    public String getCategory(){
        return category;
    }

    public Boolean isActive(){
        return status;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setTime(Instant time){
        this.time = time;
    }

    public void setCount(Integer count){
        this.count = count;
    }

    public void activate(){
        this.status = true;
    }

    public void deactivate(){
        this.status = false;
    }
}