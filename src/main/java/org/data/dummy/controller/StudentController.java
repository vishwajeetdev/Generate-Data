package org.data.dummy.controller;


import org.data.dummy.Entity.*;
import org.data.dummy.service.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    private static final Logger log = LoggerFactory.getLogger(StudentController.class);
    Logic logic;

    @Autowired
    public StudentController(Logic logic) {
        this.logic = logic;
    }


    @PostMapping("/create/{no}")
    public String createTable(@PathVariable int no) {

        String time = logic.createTable(no);


        return time;
    }

    @GetMapping
    public Map<Long, List<PersonalData>> getData(){
        return logic.get10Rows();
    }


}
