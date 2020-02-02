package com.mall.service;

import com.mall.entity.MerchantInfo;
import com.mall.vo.MerchantInfoVo;

import java.util.List;

public interface MerchantInfoService {
    public Long insertMerchant(MerchantInfo merchantInfo);
    public MerchantInfo findMerchantById(long id);
    public Long updateMerchantAuditStatus(long id, int auditStatus);
    public Long updateMerchantStatus(long id, int status);
    public List<MerchantInfo> queryByVo(MerchantInfoVo merchantInfoVo);
    public Long updateMerchantById(MerchantInfo merchantInfo);
}
