package com.example.contro;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;




import io.vavr.control.Option;
import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class testController {


    @GetMapping
    public String getMethod()
    {
        return "Get Method is called";
    }

}
