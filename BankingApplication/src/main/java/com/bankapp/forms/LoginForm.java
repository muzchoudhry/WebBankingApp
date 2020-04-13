package com.bankapp.forms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@Entity
//@Table(name = "USERPASS")
public class LoginForm {

	private String username;
	private String password;
	
}
