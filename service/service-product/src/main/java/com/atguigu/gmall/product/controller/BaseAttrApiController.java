package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.product.BaseAttrInfo;
import com.atguigu.gmall.model.product.BaseAttrValue;
import com.atguigu.gmall.product.service.BaseAttrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author chen
 * @creat 2020-11-29-13:56
 */
@RestController
@RequestMapping("admin/product")
@CrossOrigin
public class BaseAttrApiController {
    @Autowired
    BaseAttrService baseAttrService;

    @RequestMapping("attrInfoList/{category1Id}/{category2Id}/{category3Id}")
    public Result attrInfoList(@PathVariable("category3Id") Long category3Id){
        List<BaseAttrInfo> baseAttrInfos = baseAttrService.attrInfoList(category3Id);

        return Result.ok(baseAttrInfos);
    }
    @RequestMapping("saveAttrInfo")
    public Result saveAttrInfo(@RequestBody BaseAttrInfo baseAttrInfo){
     baseAttrService.saveAttrInfo(baseAttrInfo);
        return Result.ok();
    }
    ///admin/product/getAttrValueList/1
    @RequestMapping("getAttrValueList/{attrId}")
    public Result getAttrValueList(@PathVariable Long attrId){
        List<BaseAttrValue> baseAttrValues = baseAttrService.getAttrValueList(attrId);
        return Result.ok(baseAttrValues);
    }

}
