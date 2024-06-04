package com.example.exammanagement.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.Set;
@Data
@EqualsAndHashCode(exclude = "school")
@Entity
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToMany
    private Set<ExamIndustry> examIndustries =  new HashSet<ExamIndustry>();
}
