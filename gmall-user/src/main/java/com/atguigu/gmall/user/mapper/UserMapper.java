package com.atguigu.gmall.user.mapper;

import com.atguigu.gmall.user.bean.UmsMember;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

//tk.mybatis.mapper.common.Mapper是通用的增删改查,关于UmsMember的增删改查操作都
//这个Mapper都能帮你完成
public interface UserMapper extends Mapper<UmsMember> {

    List<UmsMember> selectAllUser();
}
