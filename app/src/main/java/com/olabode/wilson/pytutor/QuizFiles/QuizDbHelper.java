package com.olabode.wilson.pytutor.QuizFiles;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.olabode.wilson.pytutor.QuizFiles.QuizContract.QuestionsTable;

import java.util.ArrayList;


public class QuizDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "PyTutorQuiz.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;

    public QuizDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NR + " INTEGER" +
                ")";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        onCreate(db);
    }


    /**
     * extract and insert the question and options into their respective columns in the database.
     *
     * @param question
     */
    private void addQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        db.insert(QuestionsTable.TABLE_NAME, null, cv);
    }


    /**
     * Query the database and return a list of {@link Question}
     *
     * @return
     */
    public ArrayList<Question> getAllQuestions() {
        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME + " WHERE " + QuestionsTable._ID + " IN (SELECT " + QuestionsTable._ID
                + " FROM " + QuestionsTable.TABLE_NAME + " ORDER BY RANDOM() LIMIT 10)", null);

        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                if (questionList.size() != 10) {
                    questionList.add(question);
                } else {
                    break;
                }

            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }



    /**
     * create {@link Question} that will be inserted in the the database.
     */
    private void fillQuestionsTable() {
        Question q1 = new Question("Which of these is not a core data type?", "List",
                "Dictionary", "Class", 3);
        addQuestion(q1);

        Question q2 = new Question("What data type is the object below ?\n\t L = [1, 23, ‘hello’, 1]",
                "Dictionary", "Set", "List", 3);
        addQuestion(q2);

        Question q3 = new Question("Which of the following function convert a string to a float in python?",
                "int(x [,base])", "float(x)", "str(x)", 2);
        addQuestion(q3);

        Question q4 = new Question("print \"Hello World\"[::-1]", "dlroW olleH", "Hello Worl", "Error", 1);
        addQuestion(q4);

        Question q5 = new Question("Given a function that does not return any value, what value is shown when executed at the shell?",
                "None", "int", "string", 1);
        addQuestion(q5);

        Question q6 = new Question("Suppose you have the following datasets:\nx = ['leopard', 'panther', 'pallas cat']\nz = [(1, 1), (4, 4), (9, 9), (16, 16)]\nIn what order are they?"
                , "List, array, list of arrays", "List, list of tuples", "Dictionary,tuples", 2);
        addQuestion(q6);

        Question q7 = new Question("what is the output\nn = [[9, 8, 7], [6, 5, 4], [3, 2, 1]]\n" +
                "print n[2]", "[6, 5, 4]", "8", "[3, 2, 1]", 3);
        addQuestion(q7);

        Question q8 = new Question("In python which is the correct method to load a module ?",
                "using math", "import math", "include math", 2);
        addQuestion(q8);

        Question q9 = new Question("In python which keyword is used to start function ?",
                " function", "def", "import", 2);
        addQuestion(q9);

        Question q10 = new Question("In python 3 what does // operator do ?",
                "Integer division", "returns remainder", "same as a**b", 1);
        addQuestion(q10);

        Question q11 = new Question("Which of the following keyword is a valid placeholder for body of the function ?",
                " break", "continue", "pass", 3);
        addQuestion(q11);

        Question q12 = new Question("A variable must be assigned a value before it can be used.", "Yes", "No", "Not Sure", 1);
        addQuestion(q12);

        Question q13 = new Question("In python we use try and except for exception handling ?", "False", "True", "Not Sure", 2);
        addQuestion(q13);

        Question q14 = new Question("Is python a compiled language ?", "Yes", "Maybe", "No", 3);
        addQuestion(q14);

        Question q15 = new Question("Out of list and tuples which are mutable ?",
                "List", "Both are mutable", "Tuple", 1);
        addQuestion(q15);


        Question q16 = new Question("Which function is used to open the file for reading in python ?\n" ,
                "open(filename, mode)", "openfile(filename, mode)", "open_file(filename, mode)", 1);
        addQuestion(q16);

        Question q17 = new Question("Who created python ?",
                "Guido Van Rossum", "James Gosling", "Tom Cruise", 1);
        addQuestion(q17);

        Question q18 = new Question("Opening a file in ‘a’ mode",
                "opens a file for reading", "opens a file for appending at the end of the file", "opens a file for writing", 2);
        addQuestion(q18);

        Question q19 = new Question("for i in [1, 0]:\n" +
                "  print(i+1)",
                "2,1", "[2, 1]", "[2, 0]", 1);
        addQuestion(q19);

        Question q20 = new Question("Which is not a valid Python loop?",
                " for loop", "while loop", "iter loop", 3);
        addQuestion(q20);

        Question q21 = new Question("Does python support object oriented programming?",
                "Yes", "No", "Not sure", 1);
        addQuestion(q21);

        Question q22 = new Question("How do we get a user input from the command line?",
                " cin << 'Enter message';", "input(\"Enter message\")", " console.read(\"Enter message\")", 2);
        addQuestion(q22);

        Question q23 = new Question("Which of these prints the length of a string s?",
                "print(len(s))", "print s.length()", "print string.length(s)", 1);
        addQuestion(q23);

        Question q24 = new Question("Which operator is used to compare two numbers for equality?",
                "=", "==", " +=", 2);
        addQuestion(q24);

        Question q25 = new Question("How can we define a function in Python?",
                "int add(int a, int b):", "method add(int a, int b):", "def add(a,b):", 3);
        addQuestion(q25);

        Question q26 = new Question("for i in range(1,10):\n\tprint(i)",
                "1,2,3,4,5,6,7,8,9", "0,1,2,3,4,5,6,7,8,9,10", "1,2,3,4,5,6,7,8,9,10", 1);
        addQuestion(q26);

        Question q27 = new Question("True or false, a dictionary is always in order.",
                "Yes", "Maybe", "No", 3);
        addQuestion(q27);

        Question q28 = new Question("If User is a class, how do we make a new User object?",
                "User x = new User()", "x = new User()", "x = User()", 3);
        addQuestion(q28);

        Question q29 = new Question("What symbol can you use to comment out one line of code?",
                "**", "#", "//", 2);
        addQuestion(q29);

        Question q30 = new Question(" How do you create a variable “a” that is equal to 2?",
                "var a = 2", "a = 2", "int a = 2", 2);
        addQuestion(q30);

        Question q31 = new Question("Following set of commands are executed in shell," +
                " what will be the output?\nstr=\"hello\"\n" +
                "str[:2]", "he", "lo", "olleh", 1);
        addQuestion(q31);

        Question q32 = new Question("Select all options that print hello-how-are-you",
                "print(‘hello’,‘how’,‘are’,‘you’)", "print(‘hello’,‘how’,‘are’,‘you’+ -‘ * 4)",
                "print(‘hello-‘+‘how-are-you’)", 3);
        addQuestion(q32);

        Question q33 = new Question("What is the result of the code\nprint('a'*3)",
                "aaaa", "aaa", "aa", 2);
        addQuestion(q33);

        Question q34 = new Question("A shorter option for the \"if else\" statement is:", "elif", "ifel"
                , "elseif", 1);
        addQuestion(q34);



    }

}