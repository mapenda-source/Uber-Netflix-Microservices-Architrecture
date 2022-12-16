package com.mapenda.architecture_netflix_uber.restController;

import com.mapenda.architecture_netflix_uber.entity.MS;
import com.mapenda.architecture_netflix_uber.service.MicroserviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins ="*",allowedHeaders="*",maxAge=200000)
@RestController
@RequestMapping("/admin")
public class AdminRestController {

    @Autowired
    private MicroserviceService microService;

    @GetMapping
    public List<MS> FindAll() {

        return microService.findAll();
    }

    @GetMapping("/{pageNo}")
    public List<MS> FindPage(@PathVariable int pageNo) {

        List<MS> list = microService.findPage(pageNo,100, "id");

        return list;
    }

    @GetMapping("/{pageNo}/{pageSize}")
    public List<MS> FindPageWithSize(@PathVariable int pageNo,
                                     @PathVariable int pageSize) {

        List<MS> list = microService.findPage(pageNo,pageSize, "id");

        return list;
    }

    @GetMapping("/{pageNo}/{pageSize}/{sort}")
    public List<MS> FindPageWithSorting(@PathVariable int pageNo,
                                        @PathVariable int pageSize,
                                        @PathVariable String sort) {

        List<MS> list = microService.findPage(pageNo,pageSize,sort);

        return list;
    }

    @GetMapping("/limit/{pageSize}")
    public List<MS> FindLimit(@PathVariable int pageSize) {

        List<MS> list = microService.findPage(0,pageSize,"id");

        return list;
    }


    @GetMapping("/limit/{pageSize}/{sort}")
    public List<MS> FindLimitWithSort(@PathVariable int pageSize,
                                      @PathVariable String sort) {

        List<MS> list = microService.findPage(0,pageSize,sort);

        return list;
    }


    @GetMapping("/id/{theId}")
    public MS findById(@PathVariable int theId) {

        return microService.findById(theId);
    }


    @PostMapping("/save")
    public MS add(@RequestBody MS obj) {

        obj.setId(0);

        microService.save(obj);

        return obj;
    }

    @PostMapping("/update")
    public MS update(@RequestBody MS obj) {

        microService.save(obj);

        return obj;
    }

    @GetMapping("/delete/{theId}")
    public String delete(@PathVariable int theId) {

        microService.deleteById(theId);

        return "value deleted";
    }

}