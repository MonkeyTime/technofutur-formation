package be.wavenet.repository.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import be.wavenet.repository.UserRepository;
import be.wavenet.domain.User;
import javax.ejb.Stateless;

@Stateless(name="UserRepository")
public class MockUserRepository implements UserRepository {

    private Map<String, User> users;

    public MockUserRepository() {
        users = new HashMap<String, User>();

        User admin = new User("admin", "admin");
        admin.setId(admin.hashCode());
        admin.setAdmin(true);
        users.put("admin", admin);

        User guest = new User("guest", "guest");
        guest.setId(guest.hashCode());
        guest.setAdmin(false);
        users.put("guest", guest);
    }

    @Override
    public boolean deleteUser(User user) {
        if (user == null) {
            throw new NullPointerException("user parameter cannot be null");
        }

        return users.remove(user.getLogin()) != null ? true : false;
    }

    @Override
    public User findUser(String login) {
        return users.get(login);
    }

    @Override
    public User findUser(int id) {
        for (User u : users.values()) {
            if (u.getId() == id) {
                return u;
            }
        }

        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> findUsers() {
        return new ArrayList(users.values());
    }

    @Override
    public boolean addUser(User user) {
        if (user == null) {
            throw new NullPointerException("user parameter cannot be null");
        }

        if (users.containsKey(user.getLogin())) {
            return false;
        }

        users.put(user.getLogin(), user);
        return true;
    }

    @Override
    public boolean updateUser(User user) {
        if (user == null) {
            throw new NullPointerException("user parameter cannot be null");
        }

        if (!users.containsKey(user.getLogin())) {
            return false;
        }

        users.put(user.getLogin(), user);
        return true;
    }
}
