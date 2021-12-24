package com.cd.test.operation.revenueexpenditure;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/revenueExpenditure")
public class RevenueExpenditureController {

    @ResponseBody
    @RequestMapping("/list")
    public Map queryRevenueExpenditureInfo() {
        return null;
    }
}
    