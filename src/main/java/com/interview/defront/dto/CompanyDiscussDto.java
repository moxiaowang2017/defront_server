package com.interview.defront.dto;

import com.interview.defront.domain.DefrontCompanyDiscuss;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CompanyDiscussDto {
    private String company;
    private String recordId;
    private DefrontCompanyDiscuss defrontCompanyDiscuss;
}
