package com.atguigu.gmall.product.service;

import com.atguigu.gmall.model.product.*;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;


/**
 * @author chen
 * @creat 2020-11-30-11:18
 */
public interface SpuService {

    IPage<SpuInfo> spuList(IPage<SpuInfo> page, Long category3Id);

    void saveSpuInfo(SpuInfo spuInfo);

    List<BaseSaleAttr> baseSaleAttrList();

    List<SpuImage> spuImageList(Long spuId);

    List<SpuSaleAttr> spuSaleAttrList(Long spuId);

}
