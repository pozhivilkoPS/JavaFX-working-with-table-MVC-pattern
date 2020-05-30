package sample.Model;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;

public class FootballPlayer {
    public FootballPlayer(){
        name="";
        setDateBirthday(1,1,2000);
        team="";
        town="";
        cast="";
        position="";
    }
    private String name;
    private GregorianCalendar dateBirthday;
    private String team;
    private String town;
    private String cast;
    private String position;
    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }

    public String getDateBirthday() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return dateFormat.format(dateBirthday.getTime());


    }

    public void setDateBirthday(int day, int month, int year) {
        GregorianCalendar dateBirthday = new GregorianCalendar();
        dateBirthday.set(year, month - 1, day);
        this.dateBirthday = dateBirthday;
    }
    public void setDateBirthday(String date){
        int day=Integer.parseInt(date.substring(0,2));
        int month=Integer.parseInt(date.substring(3,5));
        int year=Integer.parseInt(date.substring(6,10));
        setDateBirthday(day,month,year);
    }


    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
