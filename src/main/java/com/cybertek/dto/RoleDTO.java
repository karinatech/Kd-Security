package com.cybertek.dto;

import com.cybertek.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RoleDTO extends Role {
    private Long id;
    private String description;
    
}
