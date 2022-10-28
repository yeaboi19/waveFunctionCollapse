package tableClasses;

import java.util.ArrayList;
import java.util.Random;

public class Cell {
    Random rng = new Random();
    private String type = "BLANK";
    private ArrayList<String> options;

    public Cell(String type, ArrayList<String> options) {
        this.type = type;
        this.options = options;
    }

    public Cell() {
        ArrayList<String> temp = new ArrayList<>();
        temp.add("UP");
        temp.add("DOWN");
        temp.add("LEFT");
        temp.add("RIGHT");
        temp.add("ALL");
        temp.add("BLANK");
        this.options = temp;

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<String> options) {
        this.options = options;
    }

    public void addOption(String option) {
        options.add(option);
    }

    public boolean removeOption(String option) {
        return options.removeIf(s -> s.equalsIgnoreCase(option));
    }
    public String typeRandomizer(){

        if((rng.nextInt()+1)%5==1 && options.size()>2)options.remove("ALL");
        if((rng.nextInt()+1)%3==0 && options.contains("BLANK"))return "BLANK";
        return options.get(Math.abs(rng.nextInt()%options.size()));
    }


    public String getURL() {
        if (type.equalsIgnoreCase("UP"))
            return "https://cdn.discordapp.com/attachments/804781929349251144/1035428947523027014/UP.png";
        if (type.equalsIgnoreCase("DOWN"))
            return "https://media.discordapp.net/attachments/804781929349251144/1035428932478054470/DOWN.png";
        if (type.equalsIgnoreCase("LEFT"))
            return "https://cdn.discordapp.com/attachments/804781929349251144/1035428938085847050/LEFT.png";
        if (type.equalsIgnoreCase("RIGHT"))
            return "https://cdn.discordapp.com/attachments/804781929349251144/1035428943475511327/RIGHT.png";
        if (type.equalsIgnoreCase("BLANK"))
            return "https://media.discordapp.net/attachments/804781929349251144/1035428927608467476/BLANK.png";
        if (type.equalsIgnoreCase("ALL"))
            return "https://media.discordapp.net/attachments/804781929349251144/1035428917173026866/All.png";

        return null;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "type='" + type + '\'' +
                ", options=" + options +
                '}';
    }
}
