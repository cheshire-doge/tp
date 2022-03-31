package seedu.duke.stubs;

import seedu.duke.data.Item;
import seedu.duke.data.ItemList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static seedu.duke.stubs.ItemStubs.ITEM_MARKER;
import static seedu.duke.stubs.ItemStubs.ITEM_PAPER_A4_10;
import static seedu.duke.stubs.ItemStubs.ITEM_PAPER_A4_15;
import static seedu.duke.stubs.ItemStubs.ITEM_PAPER_A5_10;
import static seedu.duke.stubs.ItemStubs.ITEM_PENCIL;
import static seedu.duke.stubs.ItemStubs.ITEM_WHITEBOARD;

public class CommandStubs {

    public static final ItemList SEARCH_LIST = generateItemList(ITEM_PAPER_A4_10, ITEM_PAPER_A5_10, ITEM_MARKER,
            ITEM_WHITEBOARD);
    public static final List<Item> SEARCH_RESULT_PAPER_NAME = generateImmutableResults(
            ITEM_PAPER_A4_10, ITEM_PAPER_A5_10);
    public static final List<Item> SEARCH_RESULT_DRAW_DESCRIPTION = generateImmutableResults(
            ITEM_MARKER, ITEM_WHITEBOARD);
    public static final List<Item> SEARCH_RESULT_PAPER_NAME_A4_DESCRIPTION = generateImmutableResults(ITEM_PAPER_A4_10);
    public static final List<Item> SEARCH_RESULT_NONE = generateImmutableResults();


    public static final ItemList EDIT_NEGATIVE_QUANTITY_LIST_BEFORE = generateItemList(ITEM_PAPER_A4_10);
    public static final ItemList EDIT_NAME_LIST_BEFORE = generateItemList(ITEM_PENCIL);
    public static final ItemList EDIT_NAME_EXPECTED_LIST_AFTER = generateImmutableItemList(ITEM_MARKER);
    public static final ItemList EDIT_ABSQUANTITY_LIST_BEFORE = generateItemList(ITEM_PAPER_A4_10);
    public static final ItemList EDIT_ABSQUANTITY_EXPECTED_LIST_AFTER = generateImmutableItemList(ITEM_PAPER_A4_15);
    public static final ItemList EDIT_RELQUANTITY_LIST_BEFORE = generateItemList(ITEM_PAPER_A4_15);
    public static final ItemList EDIT_RELQUANTITY_EXPECTED_LIST_AFTER = generateImmutableItemList(ITEM_PAPER_A4_10);
    public static final ItemList EDIT_DESC_LIST_BEFORE = generateItemList(ITEM_PAPER_A4_10);
    public static final ItemList EDIT_DESC_EXPECTED_LIST_AFTER = generateImmutableItemList(ITEM_PAPER_A5_10);
    public static final ItemList EDIT_ALL_LIST_BEFORE = generateItemList(ITEM_MARKER);
    public static final ItemList EDIT_ALL_EXPECTED_LIST_AFTER = generateImmutableItemList(ITEM_WHITEBOARD);

    public static final ItemList TEST_ITEM_LIST = generateItemList(ITEM_MARKER, ITEM_PENCIL, ITEM_WHITEBOARD);
    public static final ItemList TEST_ITEM_LIST_WITH_RECORDS = generateItemListWithRecords(TEST_ITEM_LIST);

    private static ItemList generateItemList(Item... items) {
        ArrayList<Item> list = new ArrayList<>();
        Collections.addAll(list, items);
        return new ItemList(list);
    }

    private static ItemList generateItemListWithRecords(ItemList itemList) {
        itemList.addBorrowRecord(0, BorrowRecordStubs.PRESENTRECORD_A);
        itemList.addBorrowRecord(0, BorrowRecordStubs.PRESENTRECORD_B);
        itemList.addBorrowRecord(1, BorrowRecordStubs.PASTRECORD_A);
        itemList.addBorrowRecord(1, BorrowRecordStubs.PASTRECORD_B);
        itemList.addBorrowRecord(2, BorrowRecordStubs.FUTURERECORD_A);
        itemList.addBorrowRecord(2, BorrowRecordStubs.FUTURERECORD_B);
        return itemList;
    }

    private static ItemList generateImmutableItemList(Item... items) {
        ArrayList<Item> list = new ArrayList<>();
        Collections.addAll(list, items);
        return new ItemList(List.copyOf(list));
    }

    /**
     * Generates an expected list of items that would represent the result.
     * This is typically used to compare against commands that do not modify ItemList. E.g. List, Search, Desc.
     * @return
     */
    private static List<Item> generateImmutableResults(Item... items) {
        ArrayList<Item> list = new ArrayList<>();
        Collections.addAll(list, items);
        return List.copyOf(list);
    }
}
