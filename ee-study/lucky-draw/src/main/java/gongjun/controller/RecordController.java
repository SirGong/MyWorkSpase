package gongjun.controller;

import gongjun.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnJava;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/record")
public class RecordController {
    @Autowired
    private RecordService recordService;

    @PostMapping("/add/{awardId}")
    public Object add (@PathVariable("awardId") Integer awardId, @RequestBody List<Integer> memberIds){
        recordService.add(awardId,memberIds);
        return null;
    }

    @GetMapping("/delete/member")
    public Object deleteByMemberId(Integer id){
        recordService.deleteByMemberId(id);
        return null;
    }
    @GetMapping("/delete/award")
    public Object deleteByAwardId(Integer id){
        recordService.deleteByAwardId(id);
        return null;
    }
}
