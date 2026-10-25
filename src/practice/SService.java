// SService.java
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class SService {

    private List<Sample> sampleList = new ArrayList<>(List.of(
        new Sample("Albert", Instant.now().plusSeconds(600), 229, true),
        new Sample("Wesker", Instant.now().plusSeconds(3600), 50),
        new Sample("Leon S.Kennedy", Instant.now().minusSeconds(1230), 25000),
        new Sample("Chole", Instant.now(), 0, true),
        new Sample("Nathan Drake", Instant.now().minusSeconds(1700), 1700, true),
        new Sample("Doom Slayer", Instant.now().minusSeconds(66666), 193000)
    ));

    public List<Sample> getSamples(Integer minCount){
        if(minCount==null || minCount<0) return sampleList;

        return sampleList
            .stream()
            .filter(sample -> sample.getCount() >= minCount)
            .collect(Collectors.toList());
    }

    public Map<String,Sample> getSamplesByCategory(){
        return sampleList
            .stream()
            .collect(Collectors.groupingBy(Sample::getCategory));
    }

    public Map<Boolean,Sample> getSampleByStatus(){
        return sampleList
            .stream()
            .collect(Collectors.partitioningBy(Sample::isActive));
    }

    public SampleStats getSampleStats(){
        return sampleList;
        // TOOD: complete this
    }

    public Integer getSampleCount(){
        return sampleList
            .stream()
            .reduce(0, (a, b) -> a.getCount() + b.getCount());
        // TOOD: complete this
    }

    public Sample getSampleById(Long id){
         return sampleList
            .stream()
            .filter(sample -> id.equals(sample.getId()))
            .findFirst()
            .orElseThrow(ResourceNotFoundException::new);
    }

    public Sample saveSample(Sample sample){
        Sample nSample = new Sample(sample.getName(), sample.getTime(), sample.getCount());
        sampleList.add(nSample);
        return nSample;
    }

    public Sample updateSample(Long id, String name, Integer count){
        return sampleList
            .stream()
            .filter(sample -> id.equals(sample.getId()))
            .findFirst()
            .map(sample -> sample.update(name, count))
            .orElseThrow(ResourceNotFoundException::new);
    }

    public Sample putSample(Long id, Map<String, Object> payload){
         return sampleList
            .stream()
            .filter(sample -> id.equals(sample.getId()))
            .findFirst()
            .map(sample -> sample.update(payload))
            .orElseThrow(ResourceNotFoundException::new);
    }

    public void deleteSample(Long id){
         sampleList = sampleList
            .stream()
            .filter(sample -> !id.equals(sample.getId()))
            .collect(Collectors.toList());
    }

}