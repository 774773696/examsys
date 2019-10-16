package com.qfedu.examsys.controller;

import com.qfedu.examsys.service.TestPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestPaperConterllor {

    @Autowired
    TestPaperService testPaperService;

}
