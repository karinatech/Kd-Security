package com.cybertek.entity;

import com.cybertek.entity.common.UserProncipaal;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class BaseEntityListener extends AuditingEntityListener {
 @PrePersist
    public void touchForCreate(BaseEntity baseEntity) {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        baseEntity.insertDateTime=LocalDateTime.now();
        baseEntity.lastUpdateDateTime=LocalDateTime.now();
        baseEntity.insertUserId=1L;
        baseEntity.lastUpdateUserId=1L;

        if(authentication!=null && !authentication.getName().equals("anonymousUser")){
            Object principal = authentication.getPrincipal();
            baseEntity.insertUserId=((UserProncipaal) principal).getId();
            baseEntity.lastUpdateUserId=((UserProncipaal) principal).getId();
        }
    }

    @PreUpdate
    public void touchForUpdate(BaseEntity baseEntity) {
       final Authentication authentication=SecurityContextHolder.getContext().getAuthentication();

       baseEntity.lastUpdateDateTime=LocalDateTime.now();
       baseEntity.lastUpdateUserId=1L;
        if(authentication!=null && !authentication.getName().equals("anonymousUser")){
            Object principal = authentication.getPrincipal();
            baseEntity.lastUpdateUserId=((UserProncipaal) principal).getId();
        }
    }
}
