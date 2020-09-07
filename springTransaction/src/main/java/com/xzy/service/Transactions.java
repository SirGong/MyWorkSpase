package com.xzy.service;

import com.xzy.dao.ScoreDao;
import com.xzy.dao.StuDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class Transactions {
    @Autowired
    StuDao stuDao;
    @Autowired
    ScoreDao scoreDao;
    //注解@Transactional 标注这个方法是一个事务方法

    /**@Transactional 的属性
     * isolation            事务的隔离级别
     * propagation          事务的传播行为
     *
     * rollbackFor          哪些异常事务可以不回滚
     * rollbackForClassName
     *
     * noRollbackFor        哪些异常事务需要回滚
     * noRollbackForClassName
     *
     * readOnly-boolean     设置只读
     * timeOut              超出指定时长停止事务并回滚
     */
    @Transactional()
    public void updateTwoTable(){
        stuDao.updateStu();
        scoreDao.updateScore();
    }

}
