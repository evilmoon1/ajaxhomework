package com.xzk.service;

import com.xzk.dao.impl.MessageDao;
import com.xzk.dao.impl.MessageDaoImpl;

import java.util.List;

/**
 * @description:
 * @date:created in 2020-08-11 19:02
 * @author:Dylan
 * @modified by:
 */
public class MessageServiceImpl implements MessageService{
    @Override
    public int count(int count) {
        MessageDaoImpl messageDao = new MessageDaoImpl();
        int count1 = messageDao.count(count);
        return count1;
    }

    @Override
    public List<String> review(String reviews) {
        MessageDaoImpl messageDao = new MessageDaoImpl();
        List<String> review = messageDao.review(reviews);
        return review;
    }
}
