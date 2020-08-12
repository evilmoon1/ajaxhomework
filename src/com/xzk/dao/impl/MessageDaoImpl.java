package com.xzk.dao.impl;

import com.xzk.util.DruidUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @date:created in 2020-08-11 17:52
 * @author:Dylan
 * @modified by:
 */
public class MessageDaoImpl extends DruidUtil implements MessageDao {
    @Override
    public  List<String> review(String reviews) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = getConnection();
        List<String> reviews1 = new ArrayList<>();
        try {
            ps = conn.prepareStatement("insert into review values(?)");
            ps.setString(1,reviews);
            System.out.println("reviews"+reviews);
            ps.execute();
            ps = conn.prepareStatement("select ? from review ");
            ps.setString(1,reviews);
            rs = ps.executeQuery();
            while(rs.next()){
                 reviews1.add(rs.getString("review"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return reviews1;
    }

    @Override
    public int count(int count) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = getConnection();
        int likecount =0;
        try {
            ps = conn.prepareStatement("update likecount set count=? + 1 ");
            ps.setInt(1,count);
            ps.executeUpdate();
            ps= conn.prepareStatement("select count from likecount");
            rs = ps.executeQuery();
            if(rs.next()){
             likecount =  rs.getInt("count");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return likecount;
    }
}
