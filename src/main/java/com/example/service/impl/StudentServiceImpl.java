package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.Student;
import com.example.mapper.StudentMapper;
import com.example.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wahoyu
 * @since 2023-07-23
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

    @Resource
    StudentMapper studentMapper;

    @Override
    public Page<Student> selectByPage(Student student, Page<Student> page) {

        //进行必要的判空操作和模糊查询,主要是name等字段,自行判断,可后续添加
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();

        if (StringUtils.isNotBlank(student.getName())) {
            queryWrapper.like("name", student.getName());
        }

        if (student.getAge() != null) {
            queryWrapper.eq("age", student.getAge());
        }
        Page<Student> studentPage = studentMapper.selectPage(page, queryWrapper);
        return studentPage;
    }
}
