package com.sparta.api_test.service;


import com.sparta.api_test.dto.TestRequestDto;
import com.sparta.api_test.entity.Test;
import com.sparta.api_test.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TestService {

    private final TestRepository testRepository;

    @Autowired
    public  TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public List<Test> getTest() {
        return testRepository.findAll();
    }

    public Optional<Test> getTest(Long id) {
        return testRepository.findById(id);
    }


    public List<Test> getTestDesc() {
        return testRepository.findAllByOrderByCreatedAtDesc();
    }

    public List<Test> postTest(TestRequestDto requestDto) {
        Test test = new Test(requestDto);
        testRepository.save(test);
        return testRepository.findAll();

    }

    public List<Test> putTest(Long id, TestRequestDto requestDto) {
        Test test = testRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        test.update(requestDto);
        return testRepository.findAll();
    }

    public List<Test> putTest(Long id,String password , TestRequestDto requestDto) {
        Test test = testRepository.findById(id).orElseThrow(
            () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        if(test.getPassword().equals(password)) {
            test.update(requestDto);
            return testRepository.findAll();
        }
        System.out.print("패스워드가 일치하지 않습니다.");
        return testRepository.findAll();
    }

    public List<Test> deleteTest(Long id) {
        testRepository.deleteById(id);
        return testRepository.findAll();
    }

}
