package by.tr.task.agregate;

import java.util.HashSet;
import java.util.Set;

import by.tr.task.bean.User;

public class Agregate {
	
	private static Set <User> users = null;
	private Agregate() {
	}

	public static Set<User> getUsers() {
		if(users == null) {
			users = new HashSet<User>();
		}
		return users;
	}

}
