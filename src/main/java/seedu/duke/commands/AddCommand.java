package seedu.duke.commands;

import static java.util.Objects.requireNonNull;

import seedu.duke.data.Item;
import seedu.duke.data.ItemList;
import seedu.duke.ui.Ui;

public class AddCommand extends Command {
    private final Item itemToAdd;

    public AddCommand(Item itemToAdd) {
        requireNonNull(itemToAdd, "item should not be null!");
        this.itemToAdd = itemToAdd;
    }

    @Override
    public void execute(Ui ui, ItemList itemList) {
        itemList.addItem(itemToAdd);
        ui.showOutput(itemToAdd + " has been added!");
    }
}