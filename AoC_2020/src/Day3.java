import java.util.List;

public class Day3 {
    
    public Day3(List<String> inputs) {

        int tree_count = 0;

        // Number of spots horisontally in the pattern that repeats
        int period = inputs.get(0).length();

        for (int i = 0; i < inputs.size(); i++) {

            // Horisontal index to check
            int x = i*3%period;

            if (inputs.get(i).charAt(x) == '#') {
                tree_count++;
            }

        }

        System.out.println("The answer to q1 is " + tree_count);

        // Answer to q2
        long sol_q2 = 1;
        

        // Right 1, down 1
        int tree_count_temp = 0;
        for (int i = 0; i < inputs.size(); i++) {

            // Horisontal index to check
            int x = i*1%period;

            if (inputs.get(i).charAt(x) == '#') {
                tree_count_temp++;
            }

        }
        sol_q2 = sol_q2*tree_count_temp;

        // Right 3, down 1
        tree_count_temp = 0;
        for (int i = 0; i < inputs.size(); i++) {

            // Horisontal index to check
            int x = i*3%period;

            if (inputs.get(i).charAt(x) == '#') {
                tree_count_temp++;
            }

        }
        sol_q2 = sol_q2*tree_count_temp;

        // Right 5, down 1
        tree_count_temp = 0;
        for (int i = 0; i < inputs.size(); i++) {

            // Horisontal index to check
            int x = i*5%period;

            if (inputs.get(i).charAt(x) == '#') {
                tree_count_temp++;
            }

        }
        sol_q2 = sol_q2*tree_count_temp;

        // Right 7, down 1
        tree_count_temp = 0;
        for (int i = 0; i < inputs.size(); i++) {

            // Horisontal index to check
            int x = i*7%period;

            if (inputs.get(i).charAt(x) == '#') {
                tree_count_temp++;
            }

        }
        sol_q2 = sol_q2*tree_count_temp;

        // Right 1, down 2
        tree_count_temp = 0;
        for (int i = 0; i < inputs.size()/2; i++) {

            // Horisontal index to check
            int x = i%period;

            if (inputs.get(i*2).charAt(x) == '#') {
                tree_count_temp++;
            }

        }
        sol_q2 = sol_q2*tree_count_temp;

        System.out.println("Answer to q2: " + sol_q2);

    }

}
