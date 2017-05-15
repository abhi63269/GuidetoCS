package model;

public class DataQuiz {
    public String question = null;
    public String op1 = null;
    public String op2 = null;
    public String op3 = null;
    public String op4 = null;
    public void setques(String s)
    {
        question = s;
    }
    public void setop1(String s)
    {
        op1 = s;
    }
    public void setop2(String s)
    {
        op2 = s;
    }
    public void setop3(String s)
    {
        op3 = s;
    }
    public void setop4(String s)
    {
        op4 = s;
    }
    public String Question()
    {
        return question;
    }
    
    public String opt1()
    {
        return op1;
    }
    public String opt2()
    {
        return op2;
    }
    public String opt3()
    {
        return op3;
    }
    public String opt4()
    {
        return op4;
    }
}
