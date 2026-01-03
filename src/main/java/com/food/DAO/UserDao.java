package com.food.DAO;

import java.util.List;

import com.food.Model.User;

public interface UserDao {
void addUser(User user);
User getUser(int userId);
void updateUser(User user);
void deleteUser(User user);
List <User> getAllUser(User user);

}
