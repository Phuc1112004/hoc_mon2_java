package com.example.exammanagement.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = "student")
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String SBD;

    @ManyToMany()
    @JoinTable(
            name = "student_subject",
            joinColumns = @JoinColumn(name = "student_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id",referencedColumnName = "id")
    )
    private Set<Subject> subjects = new HashSet<Subject>();

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;



    @OneToMany(mappedBy = "student")
    private Set<ExamIndustry> examIndustrySet = new HashSet<ExamIndustry>();

    public Student() {
    }


}
