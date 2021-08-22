package com.sh.springcloud.service;

import com.sh.springcloud.bean.Payment;
import com.sh.springcloud.dao.PaymentDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    PaymentDao paymentDao;

    public int create(Payment payment) {
        return paymentDao.insert(payment);
    }

    public Payment getPaymentById(@Param("id") Long id) {
        return paymentDao.selectByPrimaryKey(id);
    }
}
