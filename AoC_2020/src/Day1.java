import java.util.List;

public class Day1 {
    
    public Day1(List<String> inputs) {
        boolean complete = false;
		for(int i = 0; i < inputs.size(); i++)
		{
			if(complete)
				break;
			for(int j = i + 1; j < inputs.size(); j++)
			{
				int int1 = Integer.parseInt(inputs.get(i));
				int int2 = Integer.parseInt(inputs.get(j));
				if(int1 + int2 == 2020)
				{
					System.out.println("Answer to question 1: " + int1 * int2);
					complete = true;
					break;
				}
			}
		}

		for(int i = 0; i < inputs.size(); i++)
		{
			for(int j = i + 1; j < inputs.size(); j++)
			{
				for(int k = j + 1; k < inputs.size(); k++)
				{
					int int1 = Integer.parseInt(inputs.get(i));
					int int2 = Integer.parseInt(inputs.get(j));
					int int3 = Integer.parseInt(inputs.get(k));
					if(int1 + int2 + int3 == 2020)
					{
						System.out.println("Answer to question 2: " + int1 * int2 * int3);
						return;
					}
				}
			}
		}
    }
}
