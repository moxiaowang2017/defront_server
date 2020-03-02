package com.interview.defront.dto;

import com.interview.defront.domain.DefrontQuestionCompany;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CompanyQuestionDto {
    private String company;
    private List<DefrontQuestionCompany> defrontQuestionCompanys;
}
