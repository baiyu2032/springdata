
package cn.service.impl;

import cn.dao.StudentDao;
import cn.pojo.Student;
import cn.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentdao;


    @Override
    public List<Student> getall() {
        return studentdao.findAll();
    }

    @Override
    public Student sel(Integer uid) {
        Optional<Student> byId = studentdao.findById(uid);
        return byId.get();
    }

    @Override
    public String del(Integer uid) {
        studentdao.deleteById(uid);
        return "删除成功";
    }

    @Override
    public String uodata(Student uid) {

        return null;
    }

    @Override
    public Page<Student> page(Pageable pageable) {
        return studentdao.findAll(pageable);
    }

    @Override
    public List<Student> page(String upass, Pageable pageable) {
        return studentdao.findByUpass(upass,pageable);
    }


}
