package com.mall.dao;

import com.mall.entity.MerchantInfo;
import com.mall.vo.MerchantInfoVo;

import java.util.List;

public interface MerchantInfoDao {
    public Long insertMerchant(MerchantInfo merchantInfo);
    public MerchantInfo findMerchantById(long id);
    public Long updateMerchantAuditStatus(MerchantInfo merchantInfo);
    public Long updateMerchantStatus(MerchantInfo merchantInfo);
    public List<MerchantInfo> queryByVo(MerchantInfoVo merchantInfoVo);
    public Long updateMerchantById(MerchantInfo merchantInfo);
}
