import java.util.LinkedHashSet;
import java.util.List;

public class Day6 {
    public Day6(List<String> inputs) {
        String group_answers = "";
        String person_answer = "";
        String group_uniques = "";
        String group_chars_in_all = "";
        int count = 0;
        int count2 = 0;
        int group_start = 0;

        for (int i = 0; i < inputs.size(); i++) {

            person_answer = inputs.get(i);
            group_answers += person_answer;

            if( person_answer.equals("") || i == inputs.size()-1) {

                for (int ch = 0; ch < group_answers.length(); ch++) {

                    if (!group_uniques.contains(""+group_answers.charAt(ch))) {
                        
                        group_uniques += group_answers.charAt(ch);

                    }

                }

                count += group_uniques.length();

                // Q2
                List<String> group_sublist = inputs.subList(group_start, i+1);
                if (group_sublist.get(group_sublist.size()-1).equals("")) {
                    group_sublist = inputs.subList(group_start, i);
                }
                group_chars_in_all = group_sublist.get(0);
                if ( group_sublist.size() > 1 ) {
                    for (int person = 1; person < group_sublist.size(); person++) {
                        String temp = "";
                        for (int ch = 0; ch < group_sublist.get(person).length(); ch++) {
                            String current_char = "" +group_sublist.get(person).charAt(ch);
                            if ((group_chars_in_all.contains(current_char))) {
                                temp += current_char;
                            }
                        }
                        group_chars_in_all = temp;
                    }
                }

                count2 += group_chars_in_all.length();

                group_answers = "";
                group_uniques = "";
                group_start = i+1;

            }

        }

        System.out.println("The sum of every group's yes count is " + count);
        System.out.println("The sum of every group's mutual yes count is " + count2);

    }

}
