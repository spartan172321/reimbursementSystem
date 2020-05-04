package dev.rong.daotests;

import static org.junit.Assert.*;

import org.junit.Test;

import dev.rong.dao.ManagerDAO;
import dev.rong.dao.ManagerDAOMaria;

public class ManagerDAOTest {
	ManagerDAO mdao = new ManagerDAOMaria();
	@Test
	public void test() {
		System.out.println(mdao.managerLogin("alpha", "12345"));
	}

}
