package com.atguigu.gmall.user.service.impl;

import com.atguigu.gmall.user.bean.UmsMember;
import com.atguigu.gmall.user.bean.UmsMemberReceiveAddress;
import com.atguigu.gmall.user.mapper.AddressMapper;
import com.atguigu.gmall.user.mapper.UserMapper;
import com.atguigu.gmall.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    AddressMapper addressMapper;

    @Override
    public List<UmsMember> getAllUser() {
        List<UmsMember> umsMembers = userMapper.selectAll();
        return umsMembers;
    }

    @Override
    public List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId) {
        //新建一个example对象
        Example addess = new Example(UmsMemberReceiveAddress.class);
        //通用mapper的设置，设置为按某字段查询（通过memberId查询地址）
        addess.createCriteria().andEqualTo("memberId", memberId);
        /*或者是直接新建一个地址对象
         * UmsMemberReceiveAddress address = new UmsMemberReceiveAddress（）；
         * address.setMemberId(memberId);
         *
         * */
        List<UmsMemberReceiveAddress> umsMemberReceiveAddresses = addressMapper.selectByExample(addess);
        return umsMemberReceiveAddresses;
    }
}
