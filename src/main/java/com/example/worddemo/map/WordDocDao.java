package com.example.worddemo.map;

import com.example.worddemo.domain.WordDocDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface WordDocDao extends JpaRepository<WordDocDto, Integer> {

    List<WordDocDto> findByfileName(String word);
}
