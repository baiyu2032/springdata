
package cn.controller;

import cn.pojo.Student;
import cn.service.StudentService;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sel/")
@Api(value="sel/",description = "Spring boot JPA分页")
public class StudentController {
    @Autowired
    private StudentService student;

    public StudentService getStudent() {
        return this.student;
    }

    @RequestMapping(value = "getall",method = RequestMethod.GET)
    @ApiOperation(value = "查询全部",httpMethod = "GET",notes = "返回查询内容")
    public String getall(){
        List<Student> getall = student.getall();
        String s = JSON.toJSONString(getall);
        return s;
    }

    @RequestMapping(value = "selid",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value="查询地址",httpMethod="GET",notes="返回查询情况")
    public String sel(@ApiParam(required = true, name = "uid", value = "用户id")@RequestParam("uid") Integer uid){
        Student sel = student.sel(uid);
        String s = JSON.toJSONString(sel);
        return s;
    }
    @RequestMapping("delid")
    @ResponseBody
    @ApiOperation(value = "根据ID删除",httpMethod = "GET",notes = "返回删除结果")
    public String del(@ApiParam(required = true, name = "uid", value = "uid")@RequestParam("uid") Integer uid){
        String del = student.del(uid);
        return del;
    }

    @RequestMapping(value = "/getSitesBySuid",method = RequestMethod.GET)
    @ApiOperation(value = "分页实现方法一",httpMethod = "GET",notes = "返回分页内容")
    public Page<Student> getSitesBySuid(@ApiParam(required = true, name = "index", value = "当前页数")@RequestParam("index") Integer index,@ApiParam(required = true, name = "pagesize", value = "每页显示条目数")@RequestParam("pagesize") Integer pagesize){
        Pageable p = new PageRequest(index,pagesize);
        return student.page(p);
    }
    @RequestMapping(value = "/getSitesBy",method = RequestMethod.GET)
    @ApiOperation(value = "分页实现方法二",httpMethod = "GET",notes = "返回分页内容")
    public List<Student> get(@ApiParam(required = true, name = "upass", value = "状态")@RequestParam("upass")String upass,@ApiParam(required = true, name = "index", value = "当前页数")@RequestParam("index") Integer index,@ApiParam(required = true, name = "pagesize", value = "每页显示条目数")@RequestParam("pagesize") Integer pagesize){
        Pageable p = new PageRequest(index,pagesize);
        return student.page(upass,p);
    }



}
