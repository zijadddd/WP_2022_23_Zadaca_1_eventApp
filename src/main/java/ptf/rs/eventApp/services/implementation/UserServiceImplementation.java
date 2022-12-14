package ptf.rs.eventApp.services.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ptf.rs.eventApp.models.entities.User;
import ptf.rs.eventApp.models.in.UserIn;
import ptf.rs.eventApp.models.out.UserOut;
import ptf.rs.eventApp.repositories.UserRepository;
import ptf.rs.eventApp.services.UserService;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository _UserRepository;

    @Autowired
    private PasswordEncoder _PasswordEncoder;

    @Override
    public List<UserOut> getAllUsers() {
        List<User> users = _UserRepository.findAll();
        return users.stream().map(UserOut::new).collect(Collectors.toList());
    }

    public User getUserByEmail(String username) {
        return _UserRepository.findByEmail(username);
    }

    @Override
    public UserOut registerUser(UserIn userIn) {
        List<UserOut> users = this.getAllUsers();
        User temp;
        try {
            temp = new User(userIn);
            for(UserOut user : users) if(user.getEmail().equals(temp.getEmail())) throw new Exception("User postoji");
            temp.setPassword(_PasswordEncoder.encode(temp.getPassword()));
            _UserRepository.save(temp);
            return new UserOut(temp);
        } catch (Exception e) {}
        return null;
    }

    @Override
    public void banUser(String userEmail) {
        User user = _UserRepository.findByEmail(userEmail);
        user.setBanan(1);
        _UserRepository.save(user);
    }
}
