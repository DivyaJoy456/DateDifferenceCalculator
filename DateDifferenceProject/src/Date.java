public class Date {

    //fields
    String date1;
    String date2;

    //constructor
    public Date(String date1, String date2) {
        this.date1 = date1;
        this.date2 = date2;
    }

    //methods

    // date1
    //10/12/2022
    //0123456789

    //turns the day into an int
    public int getDay1() {
        String day1 = date1.substring(3, 5);
        int day = Integer.parseInt(day1);
        return day;
    }

    //turns the year into an int
    public int getYear1() {
        String year1 = date1.substring(6,date1.length());
        int year = Integer.parseInt(year1);
        return year;
    }

    //turns month into int
    public int getMonth1(){
        String m1 = date1.substring(0,2);
        int month1 = Integer.parseInt(m1);
        return month1;
    }

    //date2
    //10/12/2022
    //0123456789

    //turns the day into an int
    public int getDay2() {
        String day1 = date2.substring(3, 5);
        int day = Integer.parseInt(day1);
        return day;
    }

    //turns the year into an int
    public int getYear2() {
        String year1 = date2.substring(6,date2.length());
        int year = Integer.parseInt(year1);
        return year;
    }

    //turns month into int
    public int getMonth2(){
        String m1 = date2.substring(0, 2);
        int month1 = Integer.parseInt(m1);
        return month1;
    }

    //leap year
    public int getLeap(int year) {
        String y = Integer.toString(year);
        String m = y.substring(2, y.length());
        int l = Integer.parseInt(m);
        return l;
    }
    //get Year
    public int getYear(int y) {
        return y;
    }


}
