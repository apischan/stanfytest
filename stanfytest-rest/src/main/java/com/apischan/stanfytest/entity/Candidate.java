package com.apischan.stanfytest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.List;

@Value
public class Candidate {

    String name;

    List<String> skills;

//    public Candidate() {}
}
