package com.timesheetapp.Validation;

import com.timesheetapp.model.User;

public class UserValidation {
	public static void validate(User user) throws Exception {
		if (user.getName().isBlank() || user.getName().isEmpty()) {
			throw new Exception("Enter a valid NAME");
		} else if (user.getMobile().length() == 10) {
			char[] mobile = user.getMobile().toCharArray();
			@SuppressWarnings("unused")
			int count = 0;
			if (mobile.length > 10 || mobile.length < 10) {
				throw new Exception("Mobile Number Must Be 10 Digits Long");
			} else {
				count++;
			}
			for (char i : mobile) {
				if (Character.isAlphabetic(i)) {
					throw new Exception("Enter only Numeric values");
				} else {
					count++;
				}
			}
		} else if (!user.getEmail().contains("@")) {
			throw new Exception("Enter Valid EmailId");
		} else if (user.getPassword().isBlank() || user.getPassword().isEmpty() || user.getPassword().length() > 8) {
			throw new Exception("Enter a Valid Password");
		}

	}
}