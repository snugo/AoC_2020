import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AoC_main {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(new File("lib\\day1.txt"));
        List<Integer> inputs = new ArrayList<Integer>();
        while (s.hasNext()){
            inputs.add(Integer.parseInt(s.next()));
        }
		s.close();
		
		new Day1(inputs);
        
    }
}
