package com.sales.controller.react;

import com.sales.model.Stupid;
import com.sales.service.stupid.IStupidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/store")
public class StupidController {

    @Autowired
    private IStupidService stupidService;


    @GetMapping(value = "/lucky-user")
    public ResponseEntity<Iterable<Stupid>> getLuckyUser() {
        Iterable<Stupid> stupids = stupidService.findAll();
        return new ResponseEntity<Iterable<Stupid>>(stupids, HttpStatus.OK);
    }

//    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public ResponseEntity<House> getDetailHouse(@PathVariable Long id) {
//        House house = houseService.findById(id).get();
//        return new ResponseEntity<>(house, HttpStatus.OK);
//    }


    @PostMapping("/lucky-register")
    private ResponseEntity<Stupid> register(HttpServletResponse httpServletResponse) {
        Stupid stupid  = stupidService.register(httpServletResponse);
        return new ResponseEntity<>(stupid, HttpStatus.OK);
    }
}
