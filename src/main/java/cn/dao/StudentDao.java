package cn.dao;

import cn.pojo.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao extends JpaRepository<Student,Integer> {
    public List<Student> findByUpass(String upass, Pageable pageable);


    @Override
    public Page<Student> findAll(Pageable pageable);
}
