package pl.fotolander.fotolander.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.fotolander.fotolander.entity.User;
import pl.fotolander.fotolander.repository.UserRepository;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findAll().stream().filter(item -> item.getEmailAddress().equals(email))
                .findFirst()
                .orElseThrow(() -> {
                    throw new NoSuchElementException();
                });
        return (UserDetails) user;
    }
}
