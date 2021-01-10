import java.util.List;

public class Day4 {
    
    public Day4(List<String> inputs) {

        String current_passport = "";
        int correct_count = 0;

        for( int i = 0; i < inputs.size(); i++) {

            String current_line = inputs.get(i);
            current_passport += current_line + " ";

            if( current_line.isEmpty() || i == inputs.size()-1) {

                correct_count += evaluate(current_passport);
                current_passport = "";
            }
        }

        System.out.println("Number of valid passports: " + correct_count);



    }

    // Returns 1 is current_passport is a valid passport; 0 otherwise
    private int evaluate(String current_passport) {
        if( current_passport.contains("byr") && current_passport.contains("iyr") && current_passport.contains("eyr") && current_passport.contains("hgt") && current_passport.contains("hcl") && current_passport.contains("ecl") && current_passport.contains("pid") ) {
            
            // Check if valid for question 2
            if( valid(current_passport) ) {
                return 1;
            }
        }
        return 0;
    }

    // Returns true if each field is correct
    private boolean valid(String current_passport) {

        String byr = extract(current_passport, "byr");
        try { 
            if ( !(Integer.parseInt(byr) >= 1920 && Integer.parseInt(byr) <= 2002) ) {
                return false;
            } 
        }  
        catch (NumberFormatException e)  { 
            return false;
        } 

        String iyr = extract(current_passport, "iyr");
        try { 
            if ( !(Integer.parseInt(iyr) >= 2010 && Integer.parseInt(iyr) <= 2020) ) {
                return false;
            } 
        }  
        catch (NumberFormatException e)  { 
            return false;
        } 

        String eyr = extract(current_passport, "eyr");
        try { 
            if ( !(Integer.parseInt(eyr) >= 2020 && Integer.parseInt(eyr) <= 2030) ) {
                return false;
            } 
        }  
        catch (NumberFormatException e)  { 
            return false;
        } 

        String hgt = extract(current_passport, "hgt");
        if ( hgt.substring(hgt.length()-2).equals("cm")) {
            String hgt_nbr = hgt.substring(0, hgt.length()-2);
            try { 
                if ( !(Integer.parseInt(hgt_nbr) >= 150 && Integer.parseInt(hgt_nbr) <= 193) ) {
                    return false;
                } 
            }  
            catch (NumberFormatException e)  { 
                return false;
            } 
        }
        else if ( hgt.substring(hgt.length()-2).equals("in")) {
            String hgt_nbr = hgt.substring(0, hgt.length()-2);
            try { 
                if ( !(Integer.parseInt(hgt_nbr) >= 59 && Integer.parseInt(hgt_nbr) <= 76) ) {
                    return false;
                } 
            }  
            catch (NumberFormatException e)  { 
                return false;
            } 
        } else {
            return false;
        }

        String hcl = extract(current_passport, "hcl");
        if ( !(hcl.length() == 7 && hcl.substring(0,1).equals("#") && hcl.substring(1).matches("^[a-fA-F0-9]+$")) ) {
            return false;
        } 

        String ecl = extract(current_passport, "ecl");
        if ( !(ecl.equals("amb") || ecl.equals("blu") || ecl.equals("brn") || ecl.equals("gry") || ecl.equals("grn") || ecl.equals("hzl") || ecl.equals("oth")) ) {
            return false;
        } 

        String pid = extract(current_passport, "pid");
        try { 
            Integer.parseInt(pid);
            if ( !(pid.length() == 9) ) {
                return false;
            } 
        }  
        catch (NumberFormatException e)  { 
            return false;
        } 

        return true;
    }
    
    // Extract substring corresponding to key
    private String extract(String current_passport, String key) {
        return current_passport.substring(current_passport.indexOf(key)+4, current_passport.indexOf(key)+current_passport.substring(current_passport.indexOf(key)).indexOf(" "));
    }
}
