package com.studentmanagement.studentmanagement.entity;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "course")
public class CourseMaterial {

    @Id
    @SequenceGenerator(
            name="course_material_sequence",
            sequenceName = "course_material_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_material_sequence"
    )
    private Long CourseMaterialId;
    private String url;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, // another type is EAGER
            optional = false
    )
    @JoinColumn(
            name="course_id",
            referencedColumnName = "courseId"
    )
    private Course course;

}
