package librarySystem;


public class TableUtil {

    public static void main(String[] args) {
        
    }

    public static String formatTable(String item, int size) {
        if (item.length() < size) {
            item = String.format("%-" + size + "s", item);
        } else if (item.length() > size) {
            item = item.substring(0, 28);
        }
        return item;
    }

    public static String formatTwoDigitColumn(int columnValue, int length) {
        String columnName = String.valueOf(columnValue);
        if (columnName.length() < length) {
            columnName = "0" + columnName;
        }
        return columnName;
    }

    public static String formatTwoDigitColumnString(String columnName, int length) {
        if (columnName.length() < length) {
            columnName = "0" + columnName;
        }
        return columnName;
    }


}
