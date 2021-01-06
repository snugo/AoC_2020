import java.util.List;

public class Day2 {
    public Day2(List<String> inputs) {
        int val_count = 0;
        int val_count_q2 = 0;
        int i_dash;
        int i_space;
        int i_colon;
        int lo_nbr;
        int hi_nbr;
        char ch;
        String pw;

        for( String row : inputs) {

            // Extract info
            i_dash = row.indexOf("-");
            i_space = row.indexOf(" ");
            i_colon = row.indexOf(":");
            lo_nbr = Integer.parseInt(row.substring(0, i_dash));
            hi_nbr = Integer.parseInt(row.substring(i_dash+1, i_space));
            ch = row.charAt(i_colon - 1);
            pw = row.substring(i_colon+2);

            // Count occurrences of ch in row
            int occ_count = 0;
            for (int i = 0; i < pw.length(); i++) {
                if (pw.charAt(i) == ch) {
                    occ_count++;
                }
            }

            // Validate q1
            if (occ_count >= lo_nbr && occ_count <= hi_nbr) {
                val_count++;
            }

            // Validate q2
            
            if ((pw.charAt(lo_nbr-1) == ch || pw.charAt(hi_nbr-1) == ch) && !(pw.charAt(lo_nbr-1) == ch && pw.charAt(hi_nbr-1) == ch)) {
                val_count_q2++;
            }


        }

        System.out.println("The answere to question 1 is: " + val_count);
        System.out.println("The answere to question 2 is: " + val_count_q2);
    }
}
