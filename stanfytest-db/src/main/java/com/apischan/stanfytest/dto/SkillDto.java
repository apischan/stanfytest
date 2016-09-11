package com.apischan.stanfytest.dto;

import lombok.*;

@Data
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
public class SkillDto {

    private @NonNull Integer id;
    private @NonNull String skillName;

}
