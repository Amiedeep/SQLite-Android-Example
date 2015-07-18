package com.mycompany.sqliteandroidexample;

/**
 * Created by amandeepsingh on 18/07/15.
 */
public class StudentTable {
    public static final String TABLE_NAME="Student";
    public static final String STUDENT_COLUMN_NAME="Student_name";
    public static final String _ID="id";
    public static final String MARKS_COLUMN_NAME="Marks";
    public static final String CLASS_COLUMN_NAME="Class";

    public static final String CREATE_TABLE_QUERY = "CREATE TABLE "+TABLE_NAME+" ( "+_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                                                                                    +STUDENT_COLUMN_NAME+" TEXT NOT NULL, "
                                                                                    +CLASS_COLUMN_NAME+" TEXT, "
                                                                                    +MARKS_COLUMN_NAME+" INTEGER );";

    public static final String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS "+TABLE_NAME;

//    public static  final String DELETE_ALL_ROWS_QUERY = "DELETE FROM "+TABLE_NAME;
}
