package com.example.exammanagement.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = "room")
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String ID_Room;

    @OneToMany(mappedBy = "room")
    private List<Student> students;

    @ManyToMany
    @JoinTable(
            name = "room_supervisor",
            joinColumns = @JoinColumn(name = "room_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "supervisor_id",referencedColumnName = "id")
    )
    private Set<Supervisor> supervisor = new HashSet<>();
}
