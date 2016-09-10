package com.apischan.stanfytest.dto;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class CandidateDto {

    private @NonNull String firstname;
    private @NonNull String lastname;
    private List<SkillDto> skills;

}
