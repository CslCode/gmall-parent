package com.atguigu.gmall.product.service;

import com.atguigu.gmall.model.product.SkuInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * @author chen
 * @creat 2020-12-01-19:37
 */
public interface SkuService {
    void saveSkuInfo(SkuInfo skuInfo);

    IPage<SkuInfo> skuList(IPage<SkuInfo> page);

    void onSale(Long skuId);

    void cancelSale(Long skuId);
}
