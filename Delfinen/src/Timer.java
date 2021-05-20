public class Timer {
    private String timer;
    private String discipline;
    private String date;



    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Timer(String timer, String discipline, String date) {
        this.timer = timer;
        this.discipline = discipline;
        this.date = date;
    }

    public String getTimer() {
        return timer;
    }

    public void setTimer(String timer) {
        this.timer = timer;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    @Override
    public String toString() {
        return "Timetrial for this member:\n" +
            "Date: " + date + "\t" +
            "Discipline: " + discipline + "\t" +
            "Timer: " + timer;
    }
}
