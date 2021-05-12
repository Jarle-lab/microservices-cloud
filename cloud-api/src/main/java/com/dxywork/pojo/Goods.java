package com.dxywork.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Goods {
    private String id;
    private String name;
    private double price;
    private String serverPort; //服务端口
}
