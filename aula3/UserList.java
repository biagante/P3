package aula3;

import aula3.users.*;
import java.util.*;

public class UserList {
	
	private List<User> users = new ArrayList<>();
	
	public void addUser(User student) {
		users.add(student);
	}
	
	public void removeUser(User user) {
		users.remove(user);
	}
	
	public User getUser(int cc) {
		for (User user : usersToArray()) {
			if (user.cc() == cc) {
				return user;
			}
		}
		throw new IllegalArgumentException();
	}
	
	public int size() {
		return users.size();
	}
	
	private User[] usersToArray() {
		return users.toArray(new User[0]);
	}
}