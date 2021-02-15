package com.lollaby.user.vo;

import com.lollaby.user.entity.Department;
import com.lollaby.user.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDepVo {
 private User user;
 private Department department;
}
