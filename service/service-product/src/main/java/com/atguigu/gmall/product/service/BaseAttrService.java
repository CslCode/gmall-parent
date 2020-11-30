package com.atguigu.gmall.product.service;

import com.atguigu.gmall.model.product.BaseAttrInfo;
import com.atguigu.gmall.model.product.BaseAttrValue;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chen
 * @creat 2020-11-29-14:04
 */
public interface BaseAttrService {
    List<BaseAttrInfo> attrInfoList(Long category3Id);

    void saveAttrInfo(BaseAttrInfo baseAttrInfo);

    List<BaseAttrValue> getAttrValueList(Long attrId);
}
