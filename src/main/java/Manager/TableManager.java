package Manager;

import tableClasses.Table;

import java.util.Random;

public class TableManager {
    Table table;

    public TableManager(Table table) {
        this.table = table;
    }

    public Table getTable() {
        return table;
    }

    public String getRandomType(int currentWidth, int currentHeight) {
        return table.getCellRandomType(currentWidth, currentHeight);
    }
    //width - x
    //height - -y

    public void removeUpperCellOption(int currentWidth, int currentHeight, String option) {
        if (currentHeight > 0) table.removeOptionFromCell(currentWidth, currentHeight - 1, option);
    }

    public void removeUpperCellOptions(int currentWidth, int currentHeight, String[] options) {
        for (String option : options) {
            removeUpperCellOption(currentWidth, currentHeight, option);
        }
    }

    public void removeLowerCellOption(int currentWidth, int currentHeight, String option) {
        if (currentHeight < table.getHeight() - 1) table.removeOptionFromCell(currentWidth, currentHeight + 1, option);
    }

    public void removeLowerCellOptions(int currentWidth, int currentHeight, String[] options) {
        for (String option : options) {
            removeLowerCellOption(currentWidth, currentHeight, option);
        }
    }

    public void removeLeftCellOption(int currentWidth, int currentHeight, String option) {
        if (currentWidth > 0) table.removeOptionFromCell(currentWidth - 1, currentHeight, option);
    }

    public void removeLeftCellOptions(int currentWidth, int currentHeight, String[] options) {
        for (String option : options) {
            removeLeftCellOption(currentWidth, currentHeight, option);
        }
    }

    public void removeRightCellOption(int currentWidth, int currentHeight, String option) {
        if (currentWidth < table.getWidth() - 1) table.removeOptionFromCell(currentWidth + 1, currentHeight, option);
    }

    public void removeRightCellOptions(int currentWidth, int currentHeight, String[] options) {
        for (String option : options) {
            removeRightCellOption(currentWidth, currentHeight, option);
        }
    }

    public void removeForUp(int currentWidth, int currentHeight) {
        removeUpperCellOptions(currentWidth, currentHeight, new String[]{"UP", "BLANK"});
        removeLowerCellOptions(currentWidth, currentHeight, new String[]{"UP", "LEFT", "RIGHT", "ALL"});
        removeLeftCellOptions(currentWidth, currentHeight, new String[]{"LEFT", "BLANK"});
        removeRightCellOptions(currentWidth, currentHeight, new String[]{"RIGHT", "BLANK"});
    }

    public void removeForDown(int currentWidth, int currentHeight) {
        removeUpperCellOptions(currentWidth, currentHeight, new String[]{"DOWN", "LEFT", "RIGHT", "ALL"});
        removeLowerCellOptions(currentWidth, currentHeight, new String[]{"DOWN", "BLANK"});
        removeLeftCellOptions(currentWidth, currentHeight, new String[]{"LEFT", "BLANK"});
        removeRightCellOptions(currentWidth, currentHeight, new String[]{"RIGHT", "BLANK"});
    }

    public void removeForLeft(int currentWidth, int currentHeight) {
        removeUpperCellOptions(currentWidth, currentHeight, new String[]{"UP", "BLANK"});
        removeLowerCellOptions(currentWidth, currentHeight, new String[]{"DOWN", "BLANK"});
        removeLeftCellOptions(currentWidth, currentHeight, new String[]{"LEFT", "BLANK"});
        removeRightCellOptions(currentWidth, currentHeight, new String[]{"UP", "DOWN", "LEFT", "ALL"});
    }

    public void removeForRight(int currentWidth, int currentHeight) {
        removeUpperCellOptions(currentWidth, currentHeight, new String[]{"UP","BLANK"});
        removeLowerCellOptions(currentWidth, currentHeight, new String[]{"DOWN","BLANK"});
        removeLeftCellOptions(currentWidth, currentHeight, new String[]{"RIGHT","UP","DOWN","ALL"});
        removeRightCellOptions(currentWidth, currentHeight, new String[]{"RIGHT","BLANK"});
    }

    public void removeForBlank(int currentWidth, int currentHeight) {
        removeUpperCellOptions(currentWidth, currentHeight, new String[]{"DOWN","LEFT","RIGHT","ALL"});
        removeLowerCellOptions(currentWidth, currentHeight, new String[]{"UP","LEFT","RIGHT","ALL"});
        removeLeftCellOptions(currentWidth, currentHeight, new String[]{"UP","DOWN","RIGHT","ALL"});
        removeRightCellOptions(currentWidth, currentHeight, new String[]{"UP","DOWN","LEFT","ALL"});
    }

    public void removeForAll(int currentWidth, int currentHeight) {
        removeUpperCellOptions(currentWidth, currentHeight, new String[]{"UP","BLANK"});
        removeLowerCellOptions(currentWidth, currentHeight, new String[]{"DOWN","BLANK"});
        removeLeftCellOptions(currentWidth, currentHeight, new String[]{"LEFT","BLANK"});
        removeRightCellOptions(currentWidth, currentHeight, new String[]{"RIGHT","BLANK"});
    }

    public void setCell(int currentWidth, int currentHeight, String type) {
        switch (type) {
            case "UP" -> removeForUp(currentWidth, currentHeight);
            case "DOWN" -> removeForDown(currentWidth, currentHeight);
            case "LEFT" -> removeForLeft(currentWidth, currentHeight);
            case "RIGHT" -> removeForRight(currentWidth, currentHeight);
            case "BLANK" -> removeForBlank(currentWidth, currentHeight);
            case "ALL" -> removeForAll(currentWidth, currentHeight);
            default -> throw new IllegalStateException("Unexpected value: " + type);
        }
        table.setCellType(currentWidth, currentHeight, type);
    }

}
