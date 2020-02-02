package com.mall.service.impl;

import com.mall.service.MerchantInfoService;
import com.mall.dao.MerchantInfoDao;
import com.mall.entity.MerchantInfo;
import com.mall.vo.MerchantInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MerchantInfoImpl implements MerchantInfoService {

    @Autowired
    private MerchantInfoDao merchantInfoDao;

    @Override
    public Long insertMerchant(MerchantInfo merchantInfo) {
        merchantInfo.setAuditstatus(1);
        merchantInfo.setSoldout(1);
        return merchantInfoDao.insertMerchant(merchantInfo);
    }

    @Override
    public MerchantInfo findMerchantById(long id) {
        return merchantInfoDao.findMerchantById(id);
    }

    @Override
    public Long updateMerchantAuditStatus(long id, int auditStatus) {
        MerchantInfo merchantInfo = new MerchantInfo();
        merchantInfo.setId(id);
        merchantInfo.setAuditstatus(auditStatus);
        return merchantInfoDao.updateMerchantAuditStatus(merchantInfo);
    }

    @Override
    public Long updateMerchantStatus(long id, int status) {
        MerchantInfo merchantInfo = new MerchantInfo();
        merchantInfo.setId(id);
        merchantInfo.setSoldout(status);
        return merchantInfoDao.updateMerchantStatus(merchantInfo);
    }

    @Override
    public List<MerchantInfo> queryByVo(MerchantInfoVo merchantInfoVo) {
        return merchantInfoDao.queryByVo(merchantInfoVo);
    }

    @Override
    public Long updateMerchantById(MerchantInfo merchantInfo) {
        return merchantInfoDao.updateMerchantById(merchantInfo);
    }
}
