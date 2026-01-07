package com.food.DAO;

import java.util.List;

import com.food.Model.User;

public interface UserDao {
int addUser(User user);
User getUser(String email);
void updateUser(User user);
void deleteUser(User user);
List <User> getAllUser(User user);

}
