package codingnomads.MySql;

public class RunnersRaces {
    int id;
    int Runner_id;
    int Race_id;
    String Half_name;
    String Half_Country;
    String Runner_fname;
    String Runner_lname;

    public String getHalf_name() {
        return Half_name;
    }

    public void setHalf_name(String half_name) {
        Half_name = half_name;
    }

    public String getHalf_Country() {
        return Half_Country;
    }

    public void setHalf_Country(String half_Country) {
        Half_Country = half_Country;
    }

    public String getRunner_fname() {
        return Runner_fname;
    }

    public void setRunner_fname(String runner_fname) {
        Runner_fname = runner_fname;
    }

    public String getRunner_lname() {
        return Runner_lname;
    }

    public void setRunner_lname(String runner_lname) {
        Runner_lname = runner_lname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRunner_id() {
        return Runner_id;
    }

    public void setRunner_id(int runner_id) {
        Runner_id = runner_id;
    }

    public int getRace_id() {
        return Race_id;
    }

    public void setRace_id(int race_id) {
        Race_id = race_id;
    }
}
