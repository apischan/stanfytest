package com.apischan.stanfytest.dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class CandidateDto {

    private Integer id;
    private @NonNull String firstname;
    private @NonNull String lastname;
    private List<SkillDto> skills;

}
