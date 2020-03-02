package com.interview.defront.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WxLoginInfo {
    private String code;
    private UserInfo userInfo;
}
