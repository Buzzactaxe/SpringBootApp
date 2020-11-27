package com.example.contactmanager.repository;




import com.example.contactmanager.model.Numbers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NumbersRepository extends JpaRepository<Numbers, Integer> {


}
