package com.friend.farmers.security.services;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.friend.farmers.models.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@NoArgsConstructor
@Data
// It makes the seamless connection between the User of your application and the Security
public class UserDetailsImpl implements UserDetails {

    private static final long serialVersionID=1L;

    @Getter
    private Long id;
    private String username;
    @Getter
    private String email;

    private String mobilenumber;
    private String pancard;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(Long id, String username, String email, String password, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.mobilenumber=mobilenumber;
        this.pancard=pancard;
        this.username = username;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }


//    Convert the provided user to the UserDetails

    public static UserDetailsImpl build(User user){
       List<GrantedAuthority> authorities=user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getRoleName().name()))
                .collect(Collectors.toList());
       return new UserDetailsImpl(
               user.getUserId(),
               user.getUserName(),
               user.getEmail(),
               user.getPassword(),
               authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return authorities;
    }

    @Override
    public String getPassword(){
        return password;
    }

    @Override
    public String getUsername(){
        return username;
    }

    @Override
    public boolean isAccountNonExpired(){
        return true;
    }

    @Override
    public boolean isAccountNonLocked(){
        return true;
    }
    @Override
    public boolean isEnabled(){
        return true;
    }

    @Override
    public boolean equals(Object o){
        if(this == o)
            return true;
        if(o == null || getClass() != o.getClass())
            return false;
        UserDetailsImpl user=(UserDetailsImpl) o;
        return Objects.equals(id,user.id);
    }


}
