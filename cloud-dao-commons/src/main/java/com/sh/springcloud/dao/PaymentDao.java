package com.sh.springcloud.dao;


import com.sh.springcloud.bean.Payment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentDao {
    int deleteByPrimaryKey(Long id);

    int insert(Payment record);

    Payment selectByPrimaryKey(Long id);

    List<Payment> selectAll();

    int updateByPrimaryKey(Payment record);
}