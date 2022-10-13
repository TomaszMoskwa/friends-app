package com.project.spring.model;

import com.project.spring.model.ApplicationUser;
import com.project.spring.model.Friend;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"hobby_name"})})
@NoArgsConstructor
@AllArgsConstructor
public class Hobby {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "hobby_name")
    private String hobbyName;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Friend friend;
}
