package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.product.SkuInfo;
import com.atguigu.gmall.model.product.SpuImage;
import com.atguigu.gmall.model.product.SpuInfo;
import com.atguigu.gmall.model.product.SpuSaleAttr;
import com.atguigu.gmall.product.service.SkuService;
import com.atguigu.gmall.product.service.SpuService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author chen
 * @creat 2020-12-01-16:22
 */
@RestController
@RequestMapping("admin/product/")
@CrossOrigin
public class SkuApiController {
    @Autowired
    SpuService spuService;
    @Autowired
    SkuService skuService;

    @RequestMapping("onSale/{skuId}")
    public Result onSale(@PathVariable("skuId") Long skuId){
        skuService.onSale(skuId);
        return Result.ok();
    }
    @RequestMapping("cancelSale/{skuId}")
    public Result cancelSale(@PathVariable("skuId") Long skuId){
        skuService.cancelSale(skuId);
        return Result.ok();
    }

    @RequestMapping("saveSkuInfo")
    public Result saveSkuInfo(@RequestBody SkuInfo skuInfo){
        skuService.saveSkuInfo(skuInfo);
        return Result.ok();
    }

    @RequestMapping("spuImageList/{spuId}")
    public Result spuImageList(@PathVariable("spuId") Long spuId){
        List<SpuImage> spuImageList = spuService.spuImageList(spuId);
        return Result.ok(spuImageList);
    }

    @RequestMapping("spuSaleAttrList/{spuId}")
    public Result spuSaleAttrList(@PathVariable("spuId") Long spuId){
        List<SpuSaleAttr> spuSaleAttrList = spuService.spuSaleAttrList(spuId);
        return Result.ok(spuSaleAttrList);
    }

    @RequestMapping("list/{pageNo}/{size}")
    public Result skuList(@PathVariable("pageNo") Long pageNo ,@PathVariable("size") Long size){

        IPage<SkuInfo> page = new Page<>();

        page.setSize(size);
        page.setCurrent(pageNo);

        IPage<SkuInfo> skuInfoIPage = skuService.skuList(page);
        return Result.ok(skuInfoIPage);
    }

}
