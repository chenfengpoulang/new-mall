package com.mall.timer;

import com.mall.entity.Ordermain;
import com.mall.service.OrderService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;

public class OrderTimer2 extends QuartzJobBean {

    @Autowired
    private OrderService orderService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        List<Ordermain> allOrder = orderService.findOrderByVo(null);
        allOrder.forEach(a->{
            System.out.println(a.toString());
        });
    }
}
