// SController.java
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;
import java.util.Long;
import java.util.Integer;

@RestController
@RequestMapping("/api/v1")
public class SController {

    private final SService service;

    public SController(SService service){
        this.service = service;
    }

    @GetMapping("/samples")
    public ResponseEntity<List<Sample>> getSamples(
        @RequestParam(required = false) Integer minCount
    ){
        return ResponseEntity.ok(service.getSamples(minCount));
    }

    @GetMapping("/samples/by-category")
    public ResponseEntity<Map<String,Sample>> getSampleByCategory(){
        return ResponseEntity.ok(service.getSamplesByCategory());
    }

    @Getmapping("/samples/status-split")
    public ResponseEntity<Map<Boolean,Sample>> getSampleByStatus(){
        return ResponseEntity.ok(service.getSampleByStatus());
    }

    @GetMapping("/samples/stats")
    public ResponseEntity<SampleStats> getSampleStats(){
        return ResponseEntity.ok(service.getSampleStats());
        // TODO: complete this
    }

    @Getmapping("/samples/total-counts")
    public ResponseEntity<Integer> getSampleCount(){
        return ResponseEntity.ok(service.getSampleCount());
    }

    @GetMapping("/samples/{id}")
    public ResponseEntity<Sample> getSamples(@PathVariable Long id){
       return ResponseEntity.ok(service.getSampleById(id));
    }

    @PostMapping("/samples")
    public ResponseEntity<Sample> addSample(@RequestBody @NotNull @Valid Sample sample){
        return ResponseEntity.ok(service.saveSample(sample));
    }

    @PutMapping("/samples/{id}")
    public ResponseEntity<Sample> updateSample(
        @PathVariable Long id,
        @RequestParam String name, 
        @RequestParam Integer count
    ){
        return ResponseEntity.ok(service.updateSample(id, name, count));
    }

    @PatchMapping("/samples/{id}")
    public ResponseEntity<Sample> putSample(
        @PathVariable Long id,
        @RequestBody Map<String, Object> payload
    ){
        return ResponseEntity.ok(service.putSample(id, payload));
    }

    @DeleteMapping("/samples/{id}")
    public ResponseEntity<Void> removeSample(@PathVariable Long id){
        service.deleteSample(id);
        return ResponseEntity.noContent().build();
    }

}
