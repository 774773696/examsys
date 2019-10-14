package com.qfedu.examsys.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonBean<T> {


//   "返回数据状态编码，0正常返回，1失败"
    private int code;
//    "表示返回的具体数据，可以为null"
    private T info;

}
