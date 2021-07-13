package com.fpoly.entity;

import javax.persistence.*;
import java.util.List;
@NamedQueries({
        @NamedQuery(name = "findAll", query = "SELECT o FROM UserEntity o"),
        @NamedQuery(name = "findByUsernameAndPassword", query = "SELECT o FROM UserEntity o WHERE o.username = ?1 and o.password = ?2"),
        @NamedQuery(name = "findByPage", query = "SELECT o FROM UserEntity o"),
        @NamedQuery(name = "findByKeyword", query = "SELECT o FROM UserEntity o WHERE o.fullname LIKE ?1"),
        @NamedQuery(name = "findByRole", query = "SELECT o FROM UserEntity o WHERE o.role = ?1"),
        @NamedQuery(name = "findByUsername", query = "SELECT o FROM UserEntity o WHERE o.username = ?1"),
        @NamedQuery(name = "findByUsernameAndId", query = "SELECT o FROM UserEntity o WHERE o.username = ?1 and o.id <> ?2"),
        @NamedQuery(name = "findByEmail", query = "SELECT o FROM UserEntity o WHERE o.email = ?1")
})
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "fullname")
    private String fullname;
    @Column(name = "email")
    private String email;
    @Column(name = "role")
    private int role;

    @OneToMany(mappedBy = "user")
    List<FavoritesEntity> listFavorites;

    public List<FavoritesEntity> getListFavorites() {
        return listFavorites;
    }

    public void setListFavorites(List<FavoritesEntity> listFavorites) {
        this.listFavorites = listFavorites;
    }

    public UserEntity(String username, String password, String fullname, String email, int role) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.email = email;
        this.role = role;
    }

    public UserEntity() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String passwordl) {
        this.password = passwordl;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fullname='" + fullname + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                '}';
    }
}
