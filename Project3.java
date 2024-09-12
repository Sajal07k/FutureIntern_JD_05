import java.security.SecureRandom;
import java.util.Scanner;

public class Project3 {
    // Random Password Generator
    
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*";

    // use securerrandom
    private static final SecureRandom sr = new SecureRandom();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the password length");
        int length = sc.nextInt();

        // Edge case: check if length is valid
        if (length < 1) {
            System.out.println("Password length must be greater than 0.");
            sc.close();
            return;
        }

        System.out.println("Include uppercase letters? (yes/no): ");
        boolean includeUC = sc.next().equalsIgnoreCase("yes");

        System.out.println("Include lowercase letters? (yes/no): ");
        boolean includeLC = sc.next().equalsIgnoreCase("yes");

        System.out.println("Include digits letters? (yes/no): ");
        boolean includeDigits = sc.next().equalsIgnoreCase("yes");

        System.out.println("Include special letters? (yes/no): ");
        boolean includeSpecial = sc.next().equalsIgnoreCase("yes");

        // generate passowrd
        String password = generatePassword(length,includeUC,includeLC,includeDigits,includeSpecial);

        // print
        System.out.println("Generated password is: "+password);

        sc.close();
    }
    private static String generatePassword(int length,boolean includeUC,boolean includeLC,boolean includeDigits,boolean includeSpecial){
        StringBuilder sb = new StringBuilder();
        StringBuilder password = new StringBuilder();

        if(includeUC){
            password.append(UPPERCASE.charAt(sr.nextInt(UPPERCASE.length())));
            sb.append(UPPERCASE);
        }
        if(includeLC){
            password.append(LOWERCASE.charAt(sr.nextInt(LOWERCASE.length())));
            sb.append(LOWERCASE);
        }
        if(includeDigits){
            password.append(DIGITS.charAt(sr.nextInt(DIGITS.length())));
            sb.append(DIGITS);
        }
        if(includeSpecial){
            password.append(SPECIAL_CHARACTERS.charAt(sr.nextInt(SPECIAL_CHARACTERS.length())));
            sb.append(SPECIAL_CHARACTERS);
        }

        if(sb.length() == 0){
            return "Error : No character selected";
        }

        
        while(password.length() < length){
            password.append(sb.charAt(sr.nextInt(sb.length())));
        }

        return password.toString();
    }
}

