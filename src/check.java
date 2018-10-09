
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Karlis.Hünninen
 */
public class check {
     final static String DATE_FORMAT = "dd-MM-yyyy";

    public static boolean isDateValid(String date) {
        try {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    /**
     * Meetod kontrollib isikukoodi..
     *
     * @param id
     * @return
     */
    public static boolean checkid(List id) {
        if(isDateValid(getBirthdate(id))) {
            
        
        if (id.size() == 11 && id.contains("[a-zA-Z]+") == false) {
            int[] firstTierNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 1};
            int[] secondTierNumbers = {3, 4, 5, 6, 7, 8, 9, 1, 2, 3};
            int sum = 0;
            for (int i = 0; i < firstTierNumbers.length; i++) {
                sum = sum + (firstTierNumbers[i] * (int) id.get(i));
            }
            int jaak = sum % 11;
            if (jaak == 10) {
                sum = 0;
                for (int i = 0; i < secondTierNumbers.length; i++) {
                    sum = sum + (secondTierNumbers[i] * (int) id.get(i));
                }
                jaak = sum % 11;
            }
            // int sum = (1 * (int) id.get(0) + 2 * (int) id.get(1) + 3 * (int) id.get(2) + 4 * (int) id.get(3) + 5 * (int) id.get(4) + 6 * (int) id.get(5) + 7 * (int) id.get(6) + 8 * (int) id.get(7) + 9 * (int) id.get(8) + 1 * (int) id.get(9)) / 11;
            if (jaak == (int) id.get(10)) {
                return true;
            } else {
                System.out.println("" + sum);
                return false;

            }
            // return true;

        } else {
            return false;
        }
        } else {
            return false;
        }
        //return true;
    }

    /**
     * Sellega saab haigla nimetuse, ID alusel.
     *
     * @param id
     * @return
     */
    public static String getHospital(String idc) {
//        if() {
//            
//        }
        int id = Integer.parseInt(idc);
        System.out.println("jorss" + id);
        if (id <= 10) {
            return "Kuressaare";
        } else {
            if (id <= 19) {
                return "Tartu Ülikooli Naistekliinik, Tartumaa, Tartu";
            } else if (id <= 220) {
                return "Ida-Tallinna Keskhaigla, Pelgulinna sünnitusmaja, Hiiumaa, Keila, Rapla haigla, Loksa haigla";
            } else if (id <= 270) {
                return "Ida-Viru Keskhaigla (Kohtla-Järve, endine Jõhvi)";
            } else if (id <= 370) {
                return "Maarjamõisa Kliinikum (Tartu), Jõgeva Haigla";
            } else if (id <= 420) {
                return "Narva Haigla";
            } else if (id <= 470) {
                return "Pärnu Haigla";
            } else if (id <= 490) {
                return "Pelgulinna Sünnitusmaja (Tallinn), Haapsalu haigla";
            } else if (id <= 520) {
                return "Järvamaa Haigla (Paide)";
            } else if (id <= 570) {
                return "Rakvere, Tapa haigla";
            } else if (id <= 600) {
                return "Valga Haigla";
            } else if (id <= 650) {
                return "Viljandi Haigla";
            } else if (id <= 710) {
                return "Lõuna-Eesti Haigla (Võru), Põlva Haigla";
            } else {
                return "haiglat ple!";
            }
        }
        // return "";
    }

    /**
     * _____________________________________________ MEETOD getAge
     * --------------------------------------------- Arvutab vanuse praeguse ja
     * antud kuupäeva järgi. Selleks on vaja teada sünniaega (Aasta, kuu ja
     * päev)
     */
    public static int getAge(String Year, String month, String day) {
        System.out.println(Year + " " + month + " " + day);
        LocalDate start = LocalDate.of(Integer.parseInt(Year), Integer.parseInt(month), Integer.parseInt(day));
        //LocalDate end = LocalDate.of(2014, 2, 28); // use for age-calculation: LocalDate.now()
        LocalDate end = LocalDate.now();
        int age = (int) ChronoUnit.YEARS.between(start, end);
        if (age < 0) {
            return -1;
        } else {
            return age;
        }

    }

    /**
     * getSex - annab täpse vastuse, kas tegemist on naise v mehega. Selleks
     * tuleb anda kaasa isikukoodi massiiv. getSex väljastab ka kõik muu.
     *
     * @param id
     * @return
     */
    public static String getBirthdate(List id) {
        int Sex = 3;
        int Year = 00;

        switch ((int) id.get(0)) {
            case 1:
                Sex = 0;
                Year = 18;
                break;
            case 2:
                Sex = 1;
                Year = 18;
                break;
            case 3:
                Sex = 0;
                Year = 19;
                break;
            case 4:
                Sex = 1;
                Year = 19;
                break;
            case 5:
                Sex = 0;
                Year = 20;
                break;
            case 6:
                Sex = 1;
                Year = 20;
                break;
            default:
                Sex = 3;
                break;
        }

        return id.get(5).toString() + id.get(6).toString() + "-" + id.get(3).toString() + id.get(4).toString() + "-" + Year + id.get(1).toString() + id.get(2).toString();
    }

    public static boolean getSex(List id) {
        int Sex = 3;
        int Year = 00;

        switch ((int) id.get(0)) {
            case 1:
                Sex = 0;
                Year = 18;
                break;
            case 2:
                Sex = 1;
                Year = 18;
                break;
            case 3:
                Sex = 0;
                Year = 19;
                break;
            case 4:
                Sex = 1;
                Year = 19;
                break;
            case 5:
                Sex = 0;
                Year = 20;
                break;
            case 6:
                Sex = 1;
                Year = 20;
                break;
            default:
                Sex = 3;
                break;
        }
        MainForm.idinfo.clear();
        MainForm.idinfo.add(validatesex(Sex));
        MainForm.idinfo.add(Year + id.get(1).toString() + id.get(2).toString());
        int age = getAge(Year + id.get(1).toString() + id.get(2).toString(), id.get(3).toString() + id.get(4).toString(), id.get(5).toString() + id.get(6).toString());
        MainForm.idinfo.add(String.valueOf(age));
       // MainForm.idinfo.add(id.get(5).toString() + id.get(6).toString());
       // MainForm.idinfo.add(id.get(3).toString() + id.get(4).toString());
        MainForm.idinfo.add(getHospital(id.get(7).toString() + id.get(8).toString() + id.get(9).toString()));
        MainForm.idinfo.add(id.get(5).toString() + id.get(6).toString() + "." + id.get(3).toString() + id.get(4).toString() + "." + Year + id.get(1).toString() + id.get(2).toString());
        
        return true;
        // System.out.println(monthString);

    }

    /**
     * validatesex, väljastab soo tunnuse main classis määratud lühendi järgi...
     * töötab see siis nii, et getsex annb tulemuse 1 validatesex meetodile ja
     * see väljastab ka siis "Naine"...
     *
     * @param Sex
     * @return
     */
    public static String validatesex(int Sex) {
        if (Sex == 0) {
            return MainForm.Men;
        } else if (Sex == 1) {
            return MainForm.Women;
        } else {
            return MainForm.Wrong;
        }
    }
}
