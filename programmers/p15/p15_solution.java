import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> filteredList = new ArrayList<>();

        // Determine the index based on the 'ext' parameter
        int filterIndex = getColumnIndex(ext);
        int sortIndex = getColumnIndex(sort_by);
        
        // Filter rows based on the condition
        for (int[] row : data) {
            if (row[filterIndex] < val_ext) {
                filteredList.add(row);
            }
        }

        // Sort the filtered list based on the 'sort_by' column
        filteredList.sort(Comparator.comparingInt(row -> row[sortIndex]));

        // Convert List<int[]> to int[][]
        return filteredList.toArray(new int[0][]);
    }

    /**
     * Returns the index corresponding to the column name.
     */
    private int getColumnIndex(String column) {
        switch (column) {
            case "code": return 0;
            case "date": return 1;
            case "maximum": return 2;
            case "remain": return 3;
            default: throw new IllegalArgumentException("Invalid column name");
        }
    }
}
