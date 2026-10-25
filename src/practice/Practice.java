// practice.java
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@SpringBootApplication
@RestController
@RequestMapping
public class Practice {
    public static void main(String[] args){
        SpringApplication.run(Practice.class, args);
    }

    @GetMapping("/")
    public ResponseEntity<String> getHome(){
        return ResponseEntity.ok("This is message from spring server. How you doing?");
    }

    @GetMapping("/alive")
    public ResponseEntity<Void> getIsAlive(){
        return ResponseEntity.noContent().build();
    }
}