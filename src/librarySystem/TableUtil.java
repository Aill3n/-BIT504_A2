package librarySystem;


public class TableUtil {

    // Logic to format the table with a given size
    public static String formatTable(String item, int size) {
        if (item.length() < size) {
            item = String.format("%-" + size + "s", item);
        } else if (item.length() > size) {
            item = item.substring(0, 28);
        }
        return item;
    }

    // Logic to format a column that only has two digits - int input
    // Ads extra 0 to make the column always have 2 digits
    public static String formatTwoDigitColumn(int columnValue, int length) {
        String columnName = String.valueOf(columnValue);
        if (columnName.length() < length) {
            columnName = "0" + columnName;
        }
        return columnName;
    }

    // Logic to format a column that only has two digits - int input
    // Ads extra 0 to make the column always have 2 digits
    public static String formatTwoDigitColumnString(String columnName, int length) {
        if (columnName.length() < length) {
            columnName = "0" + columnName;
        }
        return columnName;
    }


}
