package com.cybertek.repo;

import com.cybertek.dto.ProjectDTO;
import com.cybertek.entity.Project;
import com.cybertek.entity.Task;
import com.cybertek.entity.User;
import com.cybertek.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepo extends JpaRepository<Task,Long> {
    @Query("SELECT count (t) FROM Task t WHERE t.project.projectCode=?1 AND  t.taskStatus <> 'COMPLETED'")
    int totalnonCompleteTasks(String projectCode);

@Query(value = "SELECT  count (*) from tasks t JOIN projects p on t.project_id=p.id WHERE p.project_code=?1 AND t.task_status='COMPLETED'",nativeQuery = true)
    int totalCompletedTasks(String projectCode);

List<Task> findAllByProject(Project project);
List<Task>findAllByTaskStatusIsNotAndAssignedEmployee(Status status, User user);
List<Task>findAllByProjectAssignedManager(User manager);
List<Task>findAllByTaskStatusAndAssignedEmployee(Status status,User user);

}
