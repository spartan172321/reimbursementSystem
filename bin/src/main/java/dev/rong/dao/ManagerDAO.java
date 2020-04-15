package dev.rong.dao;

import dev.rong.entities.Manager;

public interface ManagerDAO {
	Manager managerLogin(String username, String password);
}
