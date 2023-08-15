package com.example.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.Student;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wahoyu
 * @since 2023-07-23
 */
public interface IStudentService extends IService<Student> {
    Page<Student> selectByPage(Student student, Page<Student> page);
}
