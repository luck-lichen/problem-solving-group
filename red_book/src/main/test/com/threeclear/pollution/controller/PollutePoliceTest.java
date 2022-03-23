package com.threeclear.pollution.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author lianghaibin
 * @create 2022/1/13 13:45
 */
@SpringBootTest
public class PollutePoliceTest {

    @Autowired
    private PollutePoliceService pollutePoliceService;

    @Test
    public void test(){
        TaskDto taskDto = new TaskDto();
        taskDto.setTaskCode("1307002022011400069");
        taskDto.setAirCode("91351203");
        taskDto.setTaskNodeName("测试");
        pollutePoliceService.updatePollutePoliceData(taskDto);
        System.out.println("tsssssssssss");
    }
}
