package com.interview.defront.dto;

import com.interview.defront.domain.DefrontPublish;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DefrontPublishDto {
    private String concatId;
    private DefrontPublish defrontPublish;
}
