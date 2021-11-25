package springboot.UniSpringJPA.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

@Getter
@Setter
@Entity
@Table(name = "students")
public class Student implements UserDetails {

    @Id
    @GeneratedValue
    private Long studentID;

    @Column(name = "first_name", nullable = false, length = 45)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 45)
    private String lastName;

    @Column(nullable = false, length = 60, unique = true)
    private String email;

    @Column(nullable = false, length = 20)
    private String password;

    @CreationTimestamp
    private LocalDateTime regTime;

    @Column
    private String role;

    public Student() {
    }

    public Student(Long studentID,
                   String firstName,
                   String lastName,
                   String email,
                   String password,
                   LocalDateTime regTime,
                   String role) {
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.regTime = LocalDateTime.now();
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
