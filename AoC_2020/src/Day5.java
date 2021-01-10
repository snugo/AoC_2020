import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day5 {

    public Day5(List<String> inputs) {

        String bp = "";
        List<Integer> rows = IntStream.range(0, 128).boxed().collect(Collectors.toList());
        List<Integer> cols = IntStream.range(0, 8).boxed().collect(Collectors.toList());
        List<Integer> missing_ids = IntStream.range(0, 127*8+7).boxed().collect(Collectors.toList());
        int highets_id = 0;

        for ( int i = 0; i < inputs.size(); i++) {

            bp = inputs.get(i);

            // Get row
            for ( int pos = 0; pos < 7; pos++) {
                rows = narrow_down_rows(rows, bp, pos, i);
            }
            int row_nbr = rows.get(0);

            // Get column
            for ( int pos = 7; pos < 10; pos++) {
                cols = narrow_down_cols(cols, bp, pos, i);
            }
            int col_nbr = cols.get(0);

            int seat_id = row_nbr*8 + col_nbr;
            if ( seat_id > highets_id) {
                highets_id = seat_id;
            }

            missing_ids.set(seat_id, -1);

            rows = IntStream.range(0, 128).boxed().collect(Collectors.toList());
            cols = IntStream.range(0, 8).boxed().collect(Collectors.toList());
        }

        System.out.println("The highest ID is " + highets_id);

        Set<Integer> unique_ids = new HashSet<Integer>(missing_ids);
        for ( int i = 0; i < 127*8+7; i++) {
            if( unique_ids.contains(i) && !unique_ids.contains(i-1) && !unique_ids.contains(i+1) ) {
                System.out.println("The missing ID is " + i);
            }
        }

    }

    private List<Integer> narrow_down_rows(List<Integer> rows, String bp, int pos, int i) {
        List<Integer> rows_half;
        if ( bp.charAt(pos) == 'F' ) {
            rows_half = rows.subList(0, rows.size()/2);
        } else if ( bp.charAt(pos) == 'B' ) {
            rows_half = rows.subList(rows.size()/2, rows.size());
        } else {
            rows_half = rows;
            System.out.println("Row " + bp.charAt(pos) + " of input " + i + ", position " + pos + " can't be read.");
        }
        
        return rows_half;
    }

    private List<Integer> narrow_down_cols(List<Integer> cols, String bp, int pos, int i) {
        List<Integer> cols_half;
        if ( bp.charAt(pos) == 'L' ) {
            cols_half = cols.subList(0, cols.size()/2);
        } else if ( bp.charAt(pos) == 'R' ) {
            cols_half = cols.subList(cols.size()/2, cols.size());
        } else {
            cols_half = cols;
            System.out.println("Column " + bp.charAt(pos) + " of input " + i + ", position " + pos + " can't be read.");
        }
        
        return cols_half;
    }
}
