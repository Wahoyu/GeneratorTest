package com.example.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.Student;
import com.example.result.Result;
import com.example.result.ResultResponse;
import com.example.service.IStudentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigInteger;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author wahoyu
 * @since 2023-07-23
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Resource
    IStudentService iStudentService;

    /**
     * 分页查询
     */
    @GetMapping("/list")
    public Result list(Student student, Page<Student> page) {
        return ResultResponse.success(iStudentService.selectByPage(student, page));
    }

    /**
     * 根据Id查询
     */
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable BigInteger id) {
        return ResultResponse.success(iStudentService.getById(id));
    }

    /**
     * 修改
     */
    @GetMapping("/update")
    public Result update(@RequestBody Student student) {
        return ResultResponse.success(iStudentService.updateById(student));
    }

    /**
     * 删除
     */
    @DeleteMapping("/{id}")
    public Result remove(@PathVariable BigInteger id) {
        return ResultResponse.success(iStudentService.removeById(id));
    }

    @PostMapping("/add")
    public Result add(@RequestBody Student student) {
        iStudentService.save(student);
        return ResultResponse.success();
    }


}

