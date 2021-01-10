import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AoC_main {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(new File("lib\\day8.txt"));
        List<String> inputs = new ArrayList<String>();
        while (s.hasNext()){
            inputs.add(s.nextLine());
        }
		s.close();
		
		new Day8(inputs);
        
    }
}
