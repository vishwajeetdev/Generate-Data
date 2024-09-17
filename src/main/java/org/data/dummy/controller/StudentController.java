package org.data.dummy.controller;


import org.data.dummy.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import javax.sql.*;
import java.util.*;

@RestController
@RequestMapping("/student")
public class StudentController {

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


}
