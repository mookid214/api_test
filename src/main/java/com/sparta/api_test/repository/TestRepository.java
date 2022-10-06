package com.sparta.api_test.repository;

import com.sparta.api_test.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {

    List<Test> findAllByOrderByCreatedAtDesc();

}
