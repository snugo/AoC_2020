import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day8 {

    public Day8(List<String> inputs) {

        

        for (int i = 0; i < inputs.size(); i++) {

            List<Integer> exec_count = new ArrayList<Integer>(Collections.nCopies(inputs.size(), 0)); 
            int acc = 0;
            int current_pos = 0;
            String current_line = "";

            while( current_pos >= 0 && current_pos < inputs.size() && exec_count.get(current_pos) == 0) {

                exec_count.set(current_pos, 1);
    
                current_line = inputs.get(current_pos);

                if( current_pos == i) {
                    if( current_line.substring(0, 3).equals("acc")) {
                        acc += Integer.parseInt(current_line.substring(4));
                        current_pos++;
                    } else if( current_line.substring(0, 3).equals("nop")) {
                        current_pos += Integer.parseInt(current_line.substring(4));
                    } else if( current_line.substring(0, 3).equals("jmp")) {
                        current_pos++;
                    } else {
                        System.out.println("Unable to read line " + current_pos + ": " + current_line);
                    }
                } else {
                    if( current_line.substring(0, 3).equals("acc")) {
                        acc += Integer.parseInt(current_line.substring(4));
                        current_pos++;
                    } else if( current_line.substring(0, 3).equals("jmp")) {
                        current_pos += Integer.parseInt(current_line.substring(4));
                    } else if( current_line.substring(0, 3).equals("nop")) {
                        current_pos++;
                    } else {
                        System.out.println("Unable to read line " + current_pos + ": " + current_line);
                    }
                }
    
                
    
            }
    
            if( current_pos == inputs.size()) {
                System.out.println("Acc is " + acc + " when the program is fixed.");
            } else if( exec_count.get(current_pos) == 1) {
                ;
                //System.out.println("Acc is " + acc + " when line " + current_pos + " is executed the 2nd time.");
            }

        }

        
    }

    
}
