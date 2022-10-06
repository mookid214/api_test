package com.sparta.api_test.controller;


import com.sparta.api_test.dto.TestRequestDto;
import com.sparta.api_test.entity.Test;
import com.sparta.api_test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
public class TestController {

    private final TestService testService;

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }


    @GetMapping("/test")
    public List<Test> getTest() {
        return testService.getTest();
    }

    @GetMapping("/test/{id}")
    public Optional<Test> getTest(@PathVariable Long id) {
        return testService.getTest(id);
    }

    @GetMapping("/test/desc")
    public List<Test> getTestDesc() {
        return testService.getTestDesc();
    }

    @PostMapping("/test")
    public List<Test> postTest(@RequestBody TestRequestDto requestDto) {
        return testService.postTest(requestDto);
    }

    @PutMapping("/test/{id}")
    public List<Test> putTest(@PathVariable Long id,
                              @RequestBody TestRequestDto requestDto){
        return testService.putTest(id, requestDto);
    }

    @PutMapping("/test/{id}/{password}")
    public List<Test> putTest(@PathVariable Long id,
                              @PathVariable String password ,
                              @RequestBody TestRequestDto requestDto){
        return testService.putTest(id, password ,requestDto);
    }

    @DeleteMapping("/test/{id}")
    public List<Test> deleteTest(@PathVariable Long id)  {
        return testService.deleteTest(id);
    }

}
