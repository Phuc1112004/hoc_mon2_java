package com.example.exammanagement.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.Set;
@Data
@EqualsAndHashCode(exclude = "examIndustry")
@Entity
public class ExamIndustry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String ID_ExamIndustry;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "blockExecution_id")
    private BlockExecution blockExecution;

    @OneToMany(mappedBy = "examIndustry")
    private List<Subject> subjects;

    @ManyToMany
    @JoinTable(name = "examIndustry_school",joinColumns =
    @JoinColumn(name = "examIndustry_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "school_id",
            referencedColumnName = "id")
    )
    private Set<School> schools;
}
