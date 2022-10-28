package tableClasses;

import java.util.ArrayList;

public class Table {
    private ArrayList<ArrayList<Cell>> table = new ArrayList<>();
    private int width;
    private int height;

    public Table(int width, int height) {
        this.width = width;
        this.height = height;
        for (int i = 0; i < width; i++) {
            ArrayList<Cell> temp = new ArrayList<>();
            for (int j = 0; j < height; j++) {
                temp.add(new Cell());
            }
            table.add(temp);
        }
    }

    public ArrayList<ArrayList<Cell>> getTable() {
        return table;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setCell(int width, int height, Cell cell) {
        table.get(width).set(height, cell);
    }
    public void setCellType(int width, int height, String type){
        table.get(width).get(height).setType(type);
    }

    public Cell getCell(int width, int height) {
        if(width<0 || height<0)throw new IllegalArgumentException("NEGATIVE NUMBERS LOLOLOLOL");
        return table.get(width).get(height);
    }
    public String getCellRandomType(int width,int height){
        return getCell(width,height).typeRandomizer();
    }
    public String getCellURL(int width, int height) {
        return getCell(width, height).getURL();
    }

    public boolean removeOptionFromCell(int width, int height, String option) {
        return table.get(width).get(height).removeOption(option);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (ArrayList<Cell> cells : table) {
            for (Cell cell : cells) {
                sb.append(cell).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
