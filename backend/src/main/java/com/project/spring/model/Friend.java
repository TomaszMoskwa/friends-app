package com.project.spring.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private LocalDate birthday;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private ApplicationUser user;

    @OneToMany(mappedBy = "friend")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Hobby> hobbies;
}
