package com.threeclear.pollution.dto.base;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 分页参数
 * @author syf
 */
@Data
public class PageDto {
    /**
     * 页容量
     */
    @NotNull(message = "页容量不能为空")
    private Integer size;
    /**
     * 页数
     */
    @NotNull(message = "页数不能为空")
    private Integer current;
    /**
     * 跳过条数
     */
    private Integer offset;
    public Integer getOffset(){
        return (current-1)*size;
    }
}
