package com.sg.bankaccountkata.rest;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class accountController {

    @GetMapping("/accounts")
    List<String> getAll() {
        return Collections.emptyList();
    }
}
