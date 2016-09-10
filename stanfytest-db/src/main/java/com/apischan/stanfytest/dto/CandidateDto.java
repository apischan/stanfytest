package com.apischan.stanfytest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateDto {

    private String firstname;
    private String lastname;
    private List<String> skills;

}
