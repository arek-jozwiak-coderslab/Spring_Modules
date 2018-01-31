package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import pl.coderslab.entity.Student;

public interface  StudentRepository extends JpaRepository<Student, Long> {

}
