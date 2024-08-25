package com.anshSaxena._BAI10190.service;

import com.anshSaxena._BAI10190.model.UserData;
import com.anshSaxena._BAI10190.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApiService {
    @Autowired
    private UserRepository userRepository;

    public UserData processData(List<String> data, String userId, String email, String rollNumber) {
        List<String> numbers = data.stream()
                .filter(this::isNumber)
                .collect(Collectors.toList());

        List<String> alphabets = data.stream()
                .filter(this::isAlphabet)
                .collect(Collectors.toList());

        List<String> lowercaseAlphabets = alphabets.stream()
                .filter(this::isLowercase)
                .collect(Collectors.toList());

        List<String> highestLowercase = lowercaseAlphabets.isEmpty()
                ? List.of()
                : List.of(lowercaseAlphabets.stream().max(String::compareTo).orElse(""));

        UserData userData = new UserData();
        userData.setUserId(userId);
        userData.setEmail(email);
        userData.setRollNumber(rollNumber);
        userData.setNumbers(numbers);
        userData.setAlphabets(alphabets);
        userData.setHighestLowercaseAlphabet(highestLowercase);

        return userRepository.save(userData);
    }

    private boolean isNumber(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    private boolean isAlphabet(String str) {
        return str.matches("[a-zA-Z]");
    }

    private boolean isLowercase(String str) {
        return str.matches("[a-z]");
    }
}
