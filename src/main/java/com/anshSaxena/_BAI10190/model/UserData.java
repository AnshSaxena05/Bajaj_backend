package com.anshSaxena._BAI10190.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
public class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;
    private String email;
    private String rollNumber;
    @ElementCollection
    private List<String> numbers;
    @ElementCollection
    private List<String> alphabets;
    @ElementCollection
    private List<String> highestLowercaseAlphabet;
}
