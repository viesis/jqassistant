package com.buschmais.jqassistant.test.javaee6.backend.user.logic.api;

import java.io.Serializable;
import java.util.List;

import com.buschmais.jqassistant.test.javaee6.backend.user.model.api.model.User;

/**
 * Created with IntelliJ IDEA. User: dirk.mahler Date: 24.06.13 Time: 14:23 To
 * change this template use File | Settings | File Templates.
 */
public interface UserService extends Serializable {

	void create(User user);

	User update(User user);

	void delete(User user);

	List<User> getUsers();
}
