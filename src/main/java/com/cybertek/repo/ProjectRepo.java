package com.cybertek.repo;

import com.cybertek.entity.Project;
import com.cybertek.entity.User;
import com.cybertek.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepo extends JpaRepository<Project, Long> {
    Project findByProjectCode(String code);
    List<Project>findByAssignedManager(User manager);

List<Project>findAllByProjectStatusIsNot(Status status);

}
