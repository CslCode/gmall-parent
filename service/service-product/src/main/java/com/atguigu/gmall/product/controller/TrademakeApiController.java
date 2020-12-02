package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.product.BaseTrademark;
import com.atguigu.gmall.product.service.TrademarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author chen
 * @creat 2020-11-30-18:25
 */
@RestController
@RequestMapping("admin/product")
@CrossOrigin
public class TrademakeApiController {
    @Autowired
    TrademarkService trademarkService;

    //localhost:8080/admin/product/baseTrademark/getTrademarkList
    @RequestMapping("baseTrademark/getTrademarkList")
    public Result getTrademarkList(){
        List<BaseTrademark> baseTrademarks = trademarkService.getTrademarkList();
        return Result.ok(baseTrademarks);
    }
}
