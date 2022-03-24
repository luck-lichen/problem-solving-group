package com.threeclear.pollution.dto;


import lombok.Data;

import java.util.List;

/**
 * 餐饮油烟DTO
 * @author lichen
 */
@Data
public class RedBookDto {
    private String userName;
    private String password;
    private String areaCode;
    private List<String> articleIds;
}
