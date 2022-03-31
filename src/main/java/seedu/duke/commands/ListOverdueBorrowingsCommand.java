package seedu.duke.commands;

import seedu.duke.data.BorrowRecord;
import seedu.duke.data.BorrowStatus;
import seedu.duke.data.Item;
import seedu.duke.data.ItemList;
import seedu.duke.ui.Ui;

import java.util.ArrayList;
import java.util.Optional;

public class ListOverdueBorrowingsCommand extends Command {
    public static final String COMMAND_WORD = "listob";

    private final Optional<String> name;

    public ListOverdueBorrowingsCommand(Optional<String> name) {
        this.name = name;
    }

    public void execute(ItemList itemList, Ui ui) {
        ui.showMessages("Here is a list of overdue borrowings: ");

        if (name.isPresent()) {
            for (int i = 0; i < itemList.getSize(); i++) {
                Item borrowedItem = itemList.getItem(i);
                ArrayList<BorrowRecord> borrowRecords = borrowedItem.getBorrowRecords();

                for (BorrowRecord record : borrowRecords) {
                    //add check for returned
                    if (record.getBorrowStatus() == BorrowStatus.PAST && record.getBorrowerName().equals(name.get())) {
                        ui.showMessages("Name of Item: " + borrowedItem.getName(),
                                "Name of Borrower: " + record.getBorrowerName(),
                                "Borrow Duration: " + record.getBorrowDuration() + "\n");
                    }
                }
            }
        } else {
            for (int i = 0; i < itemList.getSize(); i++) {
                Item borrowedItem = itemList.getItem(i);
                ArrayList<BorrowRecord> borrowRecords = borrowedItem.getBorrowRecords();

                for (BorrowRecord record : borrowRecords) {
                    if (record.getBorrowStatus() == BorrowStatus.PAST) { //add check for returned
                        ui.showMessages("Name of Item: " + borrowedItem.getName(),
                                "Name of Borrower: " + record.getBorrowerName(),
                                "Borrow Duration: " + record.getBorrowDuration() + "\n");
                    }
                }
            }
        }
    }

}