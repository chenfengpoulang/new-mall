package com.mall.service.impl;

import com.mall.dao.OrderDetailDao;
import com.mall.dao.OrderInfoDao;
import com.mall.entity.Orderdetail;
import com.mall.entity.Ordermain;
import com.mall.service.OrderService;
import com.mall.timer.OrderTimer;
import com.mall.timer.OrderTimer2;
import com.mall.vo.ConstomOrderInfo;
import com.mall.vo.OrderInfoVo;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderInfoDao orderInfoDao;
    @Autowired
    private OrderDetailDao orderDetailDao;

    @Autowired
    private Scheduler scheduler;

    @Override
    public void insertOrder(Ordermain ordermain, List<Orderdetail> orderdetaillist) {
        ordermain.setCreatetime(new Date());
        ordermain.setPaystatus(1);
        ordermain.setOrderstatus(1);
        orderInfoDao.insertOrderMain(ordermain);
        long ordermainid = ordermain.getId();
        for(Orderdetail orderdetail : orderdetaillist ){
            orderdetail.setCreatetime(new Date());
            orderdetail.setProductid(ordermainid);
            orderDetailDao.insertOrderDetail(orderdetail);
        }
    }

    @Override
    public List<Ordermain> findOrderByVo(ConstomOrderInfo constomOrderInfo) {
        OrderInfoVo orderInfoVo = new OrderInfoVo();
        orderInfoVo.setConstomOrderInfo(constomOrderInfo);
        return orderInfoDao.findOrderByVo(orderInfoVo);
    }

    @Override
    public void updateOrderInfoById(Ordermain ordermain) {
        orderInfoDao.updateOrderInfoById(ordermain);
    }

    @Override
    public Ordermain findOrderInfoById(long id) {
        return orderInfoDao.findOrderInfoById(id);
    }

    @Override
    public void updateOrderInfoStatus(Ordermain ordermain) {
        orderInfoDao.updateOrderInfoStatus(ordermain);
    }

    @Override
    public void checkOrderTime() {
        //任务名称
        String name = UUID.randomUUID().toString();
        //任务所属分组
        String group = OrderTimer.class.getName();

        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("*/5 * * * * ?");
        //创建任务
        JobDetail jobDetail = JobBuilder.newJob(OrderTimer.class).withIdentity(name,group).build();
        //创建任务触发器
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity(name,group).withSchedule(scheduleBuilder).build();
        //将触发器与任务绑定到调度器内
        try {
            scheduler.scheduleJob(jobDetail, trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void pushOrderTime() {
        //任务名称
        String name = UUID.randomUUID().toString();
        //任务所属分组
        String group = OrderTimer2.class.getName();

        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("* * 5 * * ?");
        //创建任务
        JobDetail jobDetail = JobBuilder.newJob(OrderTimer2.class).withIdentity(name,group).build();
        //创建任务触发器
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity(name,group).withSchedule(scheduleBuilder).build();
        //将触发器与任务绑定到调度器内
        try {
            scheduler.scheduleJob(jobDetail, trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
