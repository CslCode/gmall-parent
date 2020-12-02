package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.product.BaseSaleAttr;
import com.atguigu.gmall.model.product.SpuImage;
import com.atguigu.gmall.model.product.SpuInfo;
import com.atguigu.gmall.product.service.SpuService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author chen
 * @creat 2020-11-30-10:10
 */
@RestController
@RequestMapping("admin/product")
@CrossOrigin
public class SpuApiController {
    @Autowired
    SpuService spuService;

    @RequestMapping("{pageNo}/{size}")
    public Result spuList(@PathVariable("pageNo") Long pageNo ,@PathVariable("size") Long size,Long category3Id){

        IPage<SpuInfo> page = new Page<>();

        page.setSize(size);
        page.setCurrent(pageNo);

        IPage<SpuInfo> spuInfoIPage =  spuService.spuList(page,category3Id);
        return Result.ok(spuInfoIPage);
    }
    @RequestMapping("baseSaleAttrList")
    public Result baseSaleAttrList(){
        List<BaseSaleAttr> baseSaleAttrs = spuService.baseSaleAttrList();
        return Result.ok(baseSaleAttrs);
    }
    @RequestMapping("saveSpuInfo")
    public Result saveSpuInfo(@RequestBody SpuInfo spuInfo){

        spuService.saveSpuInfo(spuInfo);
        return Result.ok();
    }

}
