package com.example.Testing.User;
import com.example.Testing.Role.Role;
import jakarta.persistence.*;
import java.util.Set;


    @Entity
    @Table(name = "_user")
    public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String username;
        private String password;
        @ManyToMany(fetch = FetchType.EAGER)
        private Set<Role> roles;
        // getters and setters


        public Long getId() {
            return id;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        public Set<Role> getRoles() {
            return roles;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public void setRoles(Set<Role> roles) {
            this.roles = roles;
        }
    }



