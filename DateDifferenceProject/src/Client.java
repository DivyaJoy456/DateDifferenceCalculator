import java.util.Scanner;
public class Client {

    //fields
    Date date;

    //Main
    public static void main(String[] args) {

        //input and output
        Scanner scan =  new Scanner(System.in);

        //date1 input
        System.out.println("write the first date in mm/dd/yyyy format");
        String da1 = scan.next();
        //date2 input
        System.out.println("write the second date in mm/dd/yyyy format");
        String da2 = scan.next();

        //prints of the output
        Client c = new Client(da1, da2);
        //System.out.println(c.totalDay());
        System.out.println(c.outPut());
    }



    //constructor
    public Client(String d1, String d2) {
        date = new Date(d1,d2);
        date.date1 = d1;
        date.date2 = d2;
    }


    //methods

    //leap year
    public boolean noLeap(int leap) {
        boolean leap1 = true;
        //if year is divisible by 4 or 400
        if(date.getLeap(leap) % 4 == 0 || date.getYear(leap) % 400 == 0) {
            return leap1;
        }
        return !leap1;
    }

    //months with 30 & 31
    //figuring out how many days in the given month
    public int nodays(int mon, int yr) {
        int days = 0;

        if(mon == 1 || mon == 3 || mon == 5 || mon == 7 || mon == 8 || mon == 10 || mon == 12) {
            days = 31;
        }
        if(mon == 4 || mon == 6 || mon == 9 || mon == 11) {
            days = 30;
        }
        //if regular year
        if(noLeap(yr) == false && mon == 2) {
            days = 28;
        }
        //if year is leap
        if(noLeap(yr) == true && mon == 2) {
            days = 29;
        }
        return days;
    }

    //if the day is greater then the
    public boolean febMonth(int day, int month, int year) {
        boolean feb = true;
        int d = nodays(month, year);
        //System.out.println(d);
        //System.out.println(day);
        if(d < day) {
            feb = false;
        }
        return feb;
    }

    //same year
    public int sameYr() {
        int sameDay = 0;
        int sum = 0;
        //if month 1 is greater than month 2
        int monthDays1 =((nodays(date.getMonth2(), date.getYear2()) - date.getDay2()) + date.getDay1());
        //if month 2 is greater than month 1
        int monthDays2 = ((nodays(date.getMonth1(), date.getYear1()) - date.getDay1()) + date.getDay2());

        if(date.getYear1() == date.getYear2()) {
            //if the month is the same
            if(date.getMonth1() == date.getMonth2()) {
                //if day 1 is greater than day 2
                if(date.getDay1() > date.getDay2()) {
                    sameDay = date.getDay1() - date.getDay2();
                }
                //if day 2 is greater than day 1
                if(date.getDay2() > date.getDay1()) {
                    sameDay = date.getDay2() - date.getDay1();
                }
            }

            //if month isn't the same
            //if the months are one apart
            if(date.getMonth1() > date.getMonth2() && date.getMonth1() - date.getMonth2() == 1) {
                sameDay = monthDays1;
            }
            if(date.getMonth2() > date.getMonth1() && date.getMonth2() - date.getMonth1() == 1) {
                sameDay = monthDays2;
            }

            //if the months are more than one apart
            //if month 1 is greater than month 2
            if(date.getMonth1() > date.getMonth2() && date.getMonth1() - date.getMonth2() > 1) {
                for(int i = date.getMonth2()+1; i < date.getMonth1(); i++) {
                    sum = sum + nodays(i, date.getYear1());
                }
                sameDay = monthDays1 + sum;
            }
            //if month 2 is greater than month 1
            if(date.getMonth2() > date.getMonth1() && date.getMonth2() - date.getMonth1() > 1) {
                for(int i = date.getMonth1()+1; i < date.getMonth2(); i++) {
                    sum = sum + nodays(i, date.getYear2());
                }
                sameDay = monthDays2 + sum;
            }
        }
        return sameDay;
    }

    //different years
    public int diffYr() {
        int diffDay = 0;
        int sum = 0;
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        //if year 1 is greater than year 2
        int year1 = ((nodays(date.getMonth2(), date.getYear2()) - date.getDay2()) + date.getDay1());
        //if year 2 is greater than year 1
        int year2 = ((nodays(date.getMonth1(), date.getYear1()) - date.getDay1()) + date.getDay2());

        //if the years are one apart
        // if year 1 is greater than year 2
        if(date.getYear1() > date.getYear2() && date.getYear1() - date.getYear2() == 1) {
            for(int i = date.getMonth2()+1; i <= 12; i++) {
                sum = sum + nodays(i, date.getYear2());
            }
            for(int i = 1; i < date.getMonth1(); i++) {
                sum1 = sum1 + nodays(i, date.getYear1());
            }
            diffDay = sum + sum1 + year1;
        }
        // if year 2 is greater than year 1
        if(date.getYear2() > date.getYear1() && date.getYear2() - date.getYear1() == 1) {
            for(int i = date.getMonth1()+1; i <= 12; i++) {
                sum = sum + nodays(i, date.getYear1());
            }
            for(int i = 1; i < date.getMonth2(); i++) {
                sum1 = sum1 + nodays(i, date.getYear2());
            }
            diffDay = sum + sum1 + year2;
        }

        //if years are more than 1 apart
        //if year 1 is greater than year 2
        if(date.getYear1() > date.getYear2() && date.getYear1() - date.getYear2() > 1) {
            for(int i = date.getYear2()+1; i < date.getYear1(); i++) {
                if(noLeap(i) == true) {
                    sum2 = sum2 + 366;
                }
                if(noLeap(i) == false) {
                    sum3 = sum3 + 365;
                }
            }
            for(int i = date.getMonth2()+1; i <= 12; i++) {
                sum = sum + nodays(i, date.getYear2());
            }
            for(int i = 1; i < date.getMonth1(); i++) {
                sum1 = sum1 + nodays(i, date.getYear1());
            }
            diffDay = sum + sum1 + sum2 + sum3 + year1;
        }
        //if year 2 is greater than year 1
        if(date.getYear2() > date.getYear1() && date.getYear2() - date.getYear1() > 1) {
            for(int i = date.getYear1()+1; i < date.getYear2(); i++) {
                if(noLeap(i) == true) {
                    sum2 = sum2 + 366;
                }
                if(noLeap(i) == false) {
                    sum3 = sum3 + 365;
                }
            }
            for(int i = date.getMonth1()+1; i <= 12; i++) {
                sum = sum + nodays(i, date.getYear1());
            }
            for(int i = 1; i < date.getMonth2(); i++) {
                sum1 = sum1 + nodays(i, date.getYear2());
            }
            diffDay = sum + sum1 + sum2 + sum3 + year2;
        }
        return diffDay;
    }

    //total days
    public int totalDay() {
        int total = 0;
        total = sameYr() + diffYr();
        return total;
    }

    //output
    public String outPut() {
        //default output
        String total =  date.date1 + " and " + date.date2 + " are " + totalDay() + " days apart.";

        //leap year issue
        //year 1 is greater than year 2
        if(date.getYear1() >  date.getYear2()) {
            for(int i = date.getYear2(); i <= date.getYear1(); i++) {
                if(noLeap(i) == true) {
                    //if year 1 is leap and the month is 2 or greater than 2}
                    if(noLeap(date.getYear1()) == true) {
                        if(date.getMonth1() == 2 || date.getMonth1() > 2) {
                            total = date.date2 + " and " + date.date1 + " are " + totalDay() + " days apart. (leap year issue)";
                        }
                        if(date.getMonth1() < 2) {
                            total = date.date2 + " and " + date.date1 + " are " + totalDay() + " days apart.";
                        }
                    }
                    //if year 2 is leap and the month is 2 or less than 2
                    if(noLeap(date.getYear2()) == true && (date.getMonth2() == 2 || date.getMonth2() < 2)) {
                        total = date.date2 + " and " + date.date1 + " are " + totalDay() + " days apart. (leap year issue)";
                    }
                    total = date.date2 + " and " + date.date1 + " are " + totalDay() + " days apart. (leap year issue)";
                }
            }
        }
        //year 2 is greater than year 1
        if(date.getYear2() >  date.getYear1()) {
            for(int i = date.getYear1(); i <= date.getYear2(); i++) {
                if(noLeap(i) == true) {
                    //if year 2 is leap and the month is 2 or greater than 2}
                    if(noLeap(date.getYear2()) == true) {
                        if(date.getMonth2() == 2 || date.getMonth2() > 2) {
                            total = date.date1 + " and " + date.date2 + " are " + totalDay() + " days apart. (leap year issue)";
                        }
                        if(date.getMonth2() < 2) {
                            total = date.date1 + " and " + date.date2 + " are " + totalDay() + " days apart.";
                        }
                    }
                    //if year 1 is leap and the month is 2 or less than 2
                    if(noLeap(date.getYear1()) == true && (date.getMonth1() == 2 || date.getMonth1() > 2)) {
                        total = date.date1 + " and " + date.date2 + " are " + totalDay() + " days apart. (leap year issue)";
                    }
                    total = date.date1 + " and " + date.date2 + " are " + totalDay() + " days apart. (leap year issue)";
                }
            }
        }
        //year 1 is equal to year 2
        if(date.getYear1() == date.getYear2()) {
            if(noLeap(date.getYear1()) == true) {
                //if month 1 is greater than month 2
                if(date.getMonth1() > date.getMonth2()) {
                    if(date.getMonth2() == 2 || date.getMonth2() < 2) {
                        total = date.date2 + " and " + date.date1 + " are " + totalDay() + " days apart. (leap year issue)";
                    }
                }
                //if month 2 is greater than month 1
                if(date.getMonth2() > date.getMonth2()) {
                    if(date.getMonth1() == 2 || date.getMonth1() < 2) {
                        total = date.date1+ " and " + date.date2 + " are " + totalDay() + " days apart. (leap year issue)";
                    }
                }
            }
        }
        //System.out.println("feb = " + febMonth(date.getDay1(), date.getMonth1(), date.getYear1()));

        //if Feb has more than 29 or 28 days
        if(febMonth(date.getDay1(), date.getMonth1(), date.getYear1()) == false) {
            total = date.date1 + " has more days than number of days in the month.";
        }
        if(febMonth(date.getDay2(), date.getMonth2(), date.getYear2()) == false) {
            total = date.date2 + " has more days than the number of days in the month.";
        }
        if(febMonth(date.getDay1(), date.getMonth1(), date.getYear1()) == false && febMonth(date.getDay2(), date.getMonth2(), date.getYear2()) == false ) {
            total = date.date1 + " and " + date.date2 + " have the wrong number of days than the number of days in the month.";
        }

        return total;
    }
}

/*
 * 06/27/1996 and 06/27/1996 are 0 days apart.
 * 06/27/1996 and 06/28/1996 are 1 days apart.
 * 01/01/1995 and 01/01/1996 are 365 days apart.
 * 01/01/1996 and 01/01/1997 are 366 days apart. (leap year issue)
 * 02/30/1996 has more days than number of days in the month.
 * 01/01/1996 and 01/01/2004 are 2922 days apart. (leap year issue)
 * 12/01/1997 and 01/01/1998 are 31 days apart.
 * 05/06/2014 and 10/05/2016 are 883 days apart. (leap year issue)
 */

