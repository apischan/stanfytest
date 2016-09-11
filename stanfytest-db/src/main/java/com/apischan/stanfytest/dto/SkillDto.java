package com.apischan.stanfytest.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class SkillDto {

    private Integer id;
    private @NonNull String skillName;

}
