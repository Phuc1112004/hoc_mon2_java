package com.example.exammanagement.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = "subject")
@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToMany(mappedBy = "subjects")
    private List<Student> student;

    @ManyToOne
    @JoinColumn(name = "examIndustry_id")
    private ExamIndustry examIndustry;
}
