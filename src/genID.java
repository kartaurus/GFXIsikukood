
import java.time.LocalDate;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Karlis.Hünninen
 */
public class genID {
//    public static boolean doID(int sex, String[] date) {

    public static String generateRandomID(int sex, int MinYear, int MaxYear) {
        String id = "";
        int years = randInt(MinYear, MaxYear);
        int months = randInt(1, 12);
        LocalDate date = LocalDate.of(years, months, 19);
        int days = date.lengthOfMonth();
        if (doID(sex, days, months, years)) {
            for (int i = 0; i < 11; i++) {
                id = id + MainForm.idnumbers.get(i);
            }
            return id;
        } else {
            return "";
        }
    }

    public static boolean doID(int sex, int days, int months, int years) {
        //  System.out.println(date[0]);
        //String[] parts = date.split("-");
        MainForm.idnumbers.clear();
        String day; // 004
        String month;
        String year = "" + years;
        if (days < 10) {
            day = "0" + days;
        } else {
            day = "" + days;
        }
        if (months < 10) {
            month = "0" + months;
        } else {
            month = "" + months;
        }
        //  System.out.println(date[0]);
        //String[] parts = date.split("-");
//        String day = date[0]; // 004
//        String month = date[1];
//        String year = date[2];

        String firstnumber = "0";
        System.out.println(year.substring(0, 2));
        if(sex == 2) {
            sex = randInt(1, 2);
        } else if(sex == 0) {
            sex = 1;
        } else {
            sex = 2;
        }
        switch (sex) {
            case 1:
                if (Integer.parseInt(year.substring(0, 2)) == 18) {
                    firstnumber = "1";
                } else if (Integer.parseInt(year.substring(0, 2)) == 19) {
                    firstnumber = "3";
                } else {
                    firstnumber = "5";
                }
                break;
            case 2:
                if (Integer.parseInt(year.substring(0, 2)) == 18) {
                    firstnumber = "2";
                } else if (Integer.parseInt(year.substring(0, 2)) == 19) {
                    firstnumber = "4";
                } else {
                    firstnumber = "6";
                }
                break;
            default:
                firstnumber = "0";
                break;
        }
        //  System.out.println(year.substring(3, 4));
        MainForm.idnumbers.add(Integer.parseInt(firstnumber));
        MainForm.idnumbers.add(Integer.parseInt(year.substring(2, 3)));
        MainForm.idnumbers.add(Integer.parseInt(year.substring(3, 4)));
        MainForm.idnumbers.add(Integer.parseInt(month.substring(0, 1)));
        MainForm.idnumbers.add(Integer.parseInt(month.substring(1, 2)));
        MainForm.idnumbers.add(Integer.parseInt(day.substring(0, 1)));
        MainForm.idnumbers.add(Integer.parseInt(day.substring(1, 2)));
        //MainForm.idnumbers.add(Integer.parseInt(day));
        MainForm.idnumbers.add(randInt(0, 7));
        MainForm.idnumbers.add(randInt(0, 1));
        MainForm.idnumbers.add(0);
        // System.out.println(MainForm.idnumbers);
        MainForm.idnumbers.add(getLastnr());

        return true;
        // System.out.println(monthString);

    }

    public static int getLastnr() {
        int[] firstTierNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 1};
        int[] secondTierNumbers = {3, 4, 5, 6, 7, 8, 9, 1, 2, 3};
        int sum = 0;
        for (int i = 0; i < firstTierNumbers.length; i++) {
            sum = sum + (firstTierNumbers[i] * (int) MainForm.idnumbers.get(i));
        }
        int jaak = sum % 11;
        if (jaak == 10) {
            sum = 0;
            for (int i = 0; i < secondTierNumbers.length; i++) {
                sum = sum + (secondTierNumbers[i] * (int) MainForm.idnumbers.get(i));
            }
            jaak = sum % 11;
        }
        // int sum = (1 * (int) id.get(0) + 2 * (int) id.get(1) + 3 * (int) id.get(2) + 4 * (int) id.get(3) + 5 * (int) id.get(4) + 6 * (int) id.get(5) + 7 * (int) id.get(6) + 8 * (int) id.get(7) + 9 * (int) id.get(8) + 1 * (int) id.get(9)) / 11;

        return jaak;

    }

    public static int randInt(int min, int max) {

        // NOTE: This will (intentionally) not run as written so that folks
        // copy-pasting have to think about how to initialize their
        // Random instance.  Initialization of the Random instance is outside
        // the main scope of the question, but some decent options are to have
        // a field that is initialized once and then re-used as needed or to
        // use ThreadLocalRandom (if using at least Java 1.7).
        // 
        // In particular, do NOT do 'Random rand = new Random()' here or you
        // will get not very good / not very random results.
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;
//        if (randomNum < 100 && randomNum > 10) {
//            return Integer.parseInt("0") + randomNum;
//        } else if (randomNum < 10) {
//            return Integer.parseInt("00") + randomNum;
//        } else {

        return randomNum;
//        }
        //return randomNum;
    }
}
