package com.apischan.stanfytest.dto;

import lombok.*;

@Data
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
@AllArgsConstructor(staticName = "of")
public class SkillDto {

    private Integer id;
    private @NonNull String skillName;

}
