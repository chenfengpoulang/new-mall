package com.mall.dao.impl;

import com.mall.dao.MerchantInfoDao;
import com.mall.mappers.MerchantMapper;
import com.mall.entity.MerchantInfo;
import com.mall.vo.MerchantInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MerchantInfoDaoImpl implements MerchantInfoDao {

    @Autowired
    private MerchantMapper merchantMapper;

    @Override
    public Long insertMerchant(MerchantInfo merchantInfo) {
        return merchantMapper.insertMerchant(merchantInfo);
    }

    @Override
    public MerchantInfo findMerchantById(long id) {
        return merchantMapper.findMerchantById(id);
    }

    @Override
    public Long updateMerchantAuditStatus(MerchantInfo merchantInfo) {
        return merchantMapper.updateMerchantAuditStatus(merchantInfo);
    }

    @Override
    public Long updateMerchantStatus(MerchantInfo merchantInfo) {
        return merchantMapper.updateMerchantStatus(merchantInfo);
    }

    @Override
    public List<MerchantInfo> queryByVo(MerchantInfoVo merchantInfoVo) {
        return merchantMapper.queryByVo(merchantInfoVo);
    }

    @Override
    public Long updateMerchantById(MerchantInfo merchantInfo) {
        return merchantMapper.updateMerchantById(merchantInfo);
    }
}
