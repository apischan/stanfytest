package com.apischan.stanfytest.dto;

import lombok.*;

import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
public class CandidateDto {

    private @NonNull Integer id;
    private @NonNull String firstname;
    private @NonNull String lastname;
    private @NonNull List<SkillDto> skills = Collections.emptyList();

}
