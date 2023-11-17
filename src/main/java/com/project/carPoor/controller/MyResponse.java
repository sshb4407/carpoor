package com.project.carPoor.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL) // 데이터 json 타입으로 자동 변환 (리턴시)
public class MyResponse { // 비동기로 보낼 데이터

    private boolean passed;

}
