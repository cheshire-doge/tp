package seedu.duke;

import java.util.ArrayList;

public class Storage {
    private String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public ArrayList<Item> load() {
        return new ArrayList<Item>();
    }

}
