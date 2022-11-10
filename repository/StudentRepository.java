package com.gl.lab6.studentfest.Lab6.StudentFest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gl.lab6.studentfest.Lab6.StudentFest.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

}
