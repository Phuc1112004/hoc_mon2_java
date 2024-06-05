package com.example.exammanagement.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(exclude = "blockExecution")
@Entity
public class BlockExecution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String ID_Block;

    @OneToMany(mappedBy = "blockExecution")
    private List<ExamIndustry> examIndustries;
}
