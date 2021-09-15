package com.example.DemoOnetoOne.BaseResponse;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter

public class BaseResponse<T> {
    private String statuscode;
    private String statusmessage;
    private T Data;
}

