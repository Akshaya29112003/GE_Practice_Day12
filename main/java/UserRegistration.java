import java.util.regex.Pattern;

public class UserRegistration {
        public static void validateFirstName(String fname) throws UserDetailsException {
            String fname_regex = "^[A-Z][A-Za-z]{2,}$";
            if (!Pattern.matches(fname_regex, fname)) {
                throw new UserDetailsException("Invalid First Name: Must start with a capital letter and have at least 3 characters.");
            }
        }

        public static void validateLastName(String lname) throws UserDetailsException {
            String lname_regex = "^[A-Z][A-Za-z]{2,}$";
            if (!Pattern.matches(lname_regex, lname)) {
                throw new UserDetailsException("Invalid Last Name: Must start with a capital letter and have at least 3 characters.");
            }
        }

        public static void validateEmail(String email) throws UserDetailsException {
            String email_regex = "^[a-zA-Z0-9]+(\\.[a-zA-Z0-9]+)?@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}(\\.[a-zA-Z]{2,})?$";
            if (!Pattern.matches(email_regex, email)) {
                throw new UserDetailsException("Invalid Email: Must follow the format abc.xyz@bl.co.in.");
            }
        }

        public static void validatePhone(String phn) throws UserDetailsException {
            String phn_regex = "^[0-9]{2} [0-9]{10}$";
            if (!Pattern.matches(phn_regex, phn)) {
                throw new UserDetailsException("Invalid Phone Number: Must follow the format 91 1234567890.");
            }
        }

        public static void validatePassword(String pass) throws UserDetailsException {
            String pass_regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$";
            int specialCharCount = pass.replaceAll("[^@#$%^&+=!]", "").length();

            if (!Pattern.matches(pass_regex, pass) || specialCharCount != 1) {
                throw new UserDetailsException("Invalid Password: Must have:\n"
                        + "- Minimum 8 characters\n"
                        + "- At least 1 uppercase letter\n"
                        + "- At least 1 numeric digit\n"
                        + "- Exactly 1 special character.");
            }
        }
    }
