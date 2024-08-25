package com.anshSaxena._BAI10190.controller;

import com.anshSaxena._BAI10190.model.UserData;
import com.anshSaxena._BAI10190.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/bfhl")
public class ApiController {
    @Autowired
    private ApiService apiService;

    @PostMapping
    public ResponseEntity<Map<String, Object>> processRequest(@RequestBody Map<String, Object> request) {
        List<String> data = (List<String>) request.get("data");
        String userId = "ansh_saxena_21BAI10190";
        String email = "anshs5103@gmail.com";
        String rollNumber = "21BAI10190";

        UserData userData = apiService.processData(data, userId, email, rollNumber);

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("is_success", true);
        response.put("user_id", userData.getUserId());
        response.put("email", userData.getEmail());
        response.put("roll_number", userData.getRollNumber());
        response.put("numbers", userData.getNumbers());
        response.put("alphabets", userData.getAlphabets());
        response.put("highest_lowercase_alphabet", userData.getHighestLowercaseAlphabet());

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Map<String, Integer>> getOperationCode() {
        return ResponseEntity.ok(Map.of("operation_code", 1));
    }
}
