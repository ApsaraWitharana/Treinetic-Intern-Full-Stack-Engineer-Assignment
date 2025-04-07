package lk.ijse.gdse68.userservice.service;


import lk.ijse.gdse68.userservice.dao.UserRepository;
import lk.ijse.gdse68.userservice.dto.AuthDTO;
import lk.ijse.gdse68.userservice.dto.UserDTO;
import lk.ijse.gdse68.userservice.entity.UserEntity;
import lk.ijse.gdse68.userservice.util.VarList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Transactional
@Service
public class UserServiceImpl implements UserDetailsService, UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public int saveUser(UserDTO userDTO) {
        if (userRepository.existsByEmail(userDTO.getEmail())) {
            return VarList.Not_Acceptable;
        } else {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
            AuthDTO authDTO = new AuthDTO();
            userRepository.save(modelMapper.map(userDTO, UserEntity.class));
            return VarList.Created;
        }

    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByEmail(email);
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(), getAuthority(user));
    }

    public UserDTO loadUserDetailsByUsername(String userName) throws UsernameNotFoundException{
        UserEntity user = userRepository.findByEmail(userName);
        return modelMapper.map(user,UserDTO.class);
    }

    private Set<SimpleGrantedAuthority> getAuthority(UserEntity user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(user.getEmail()));
        return authorities;
    }

    @Override
    public UserDTO searchUser(String userName) {
        if (userRepository.existsByEmail(userName)){
            UserEntity user = userRepository.findByEmail(userName);
            return modelMapper.map(user,UserDTO.class);
        }else {
            return null;
        }
    }


}
