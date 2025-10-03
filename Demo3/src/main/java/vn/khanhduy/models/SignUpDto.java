package vn.khanhduy.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SignUpDto {

	String name;
	String username;
	String email;
	String password;
	boolean enabled;
}
