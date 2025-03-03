package org.darker.entity;

import java.util.List;

import javax.management.relation.Role;

import jakarta.persistence.*;


@Entity
@Table(name="users")
public class User {
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private Long id;
   
   @Column(nullable=false)
   private String name;
   
   @Column(unique=true , nullable=false)
   private String email;
   
   @Column(nullable=false)
   private String password;
   
   @Enumerated(EnumType.STRING)
   @Column(nullable=false)
   private Role role;
   
   @OneToOne(mappedBy="user", cascade=CascadeType.ALL)
   private Savings savings;
   
   @OneToMany(mappedBy="user", cascade=CascadeType.ALL, orphanRemoval=true)
   private List<Expense> expenses;

public User() {
	
}

public User(String name, String email, String password, Role role) {
	
	this.name = name;
	this.email = email;
	this.password = password;
	this.role = role;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public Role getRole() {
	return role;
}

public void setRole(Role role) {
	this.role = role;
}

public Savings getSavings() {
	return savings;
}

public void setSavings(Savings savings) {
	this.savings = savings;
}

public List<Expense> getExpenses() {
	return expenses;
}

public void setExpenses(List<Expense> expenses) {
	this.expenses = expenses;
} 
}
