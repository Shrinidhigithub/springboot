package com.springguides.springboot.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")
@Data
public class Student {


//    public void Student(String stuName, int stuAge, int stuHeight, int stuWeight) {
//        this.stuName = stuName;
//        this.StuAge = stuAge;
//        this.StuHeight = stuHeight;
//        this.StuWeight = stuWeight;
//    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "height")
    private int height;

    @Column(name = "weight")
    private int weight;

}
