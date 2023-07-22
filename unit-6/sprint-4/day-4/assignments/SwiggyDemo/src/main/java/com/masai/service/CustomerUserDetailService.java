package com.masai.service;

import com.masai.model.Customer;
import com.masai.repository.customerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerUserDetailService implements UserDetailsService {
    @Autowired
    private customerRepository cRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Customer> opt = cRepo.findByEmail(username);

        if(opt.isPresent()){
            Customer customer = opt.get();
            List<GrantedAuthority> authorities = new ArrayList<>();
            SimpleGrantedAuthority sga = new SimpleGrantedAuthority(customer.getRole());
            authorities.add(sga);
            return new User(customer.getName(),customer.getPassword(),authorities);
        }else {
            throw new BadCredentialsException("Invalid Credential found");
        }
    }
}
