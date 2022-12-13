package ptf.rs.eventApp.services;

import java.util.List;

import ptf.rs.eventApp.models.entities.User;
import ptf.rs.eventApp.models.in.UserIn;
import ptf.rs.eventApp.models.out.UserOut;

public interface UserService {
    public List<UserOut> getAllUsers();
    public User getUserByEmail(String username);
    public UserOut registerUser(UserIn userIn);
    public void banUser(String userEmail);
}
