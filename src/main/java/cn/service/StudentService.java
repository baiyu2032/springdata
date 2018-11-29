package cn.service;

import cn.dao.StudentDao;
import cn.pojo.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudentService {

     List<Student> getall();

     Student sel(Integer uid);

     String del(Integer uid);

     String uodata(Student uid);

     Page<Student> page(Pageable pageable);

     List<Student> page(String upass,Pageable pageable);

}
