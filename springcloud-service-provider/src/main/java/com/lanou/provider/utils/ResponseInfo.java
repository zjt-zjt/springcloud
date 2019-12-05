package com.lanou.provider.utils;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ResponseInfo {
    private int code;
    private  String msg;
    private Object data;

}
