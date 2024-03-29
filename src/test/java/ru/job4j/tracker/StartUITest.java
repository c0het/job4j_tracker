package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem()  {
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        MemTracker memTracker = new MemTracker();
        List<UserAction> actions = Arrays.asList(
                new CreateAction(output),
                new CloseAction(output)
        );
        new StartUI(output).init(in, memTracker, actions);
        assertThat(memTracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        MemTracker memTracker = new MemTracker();
        Output output = new StubOutput();
        Item item = memTracker.add(new Item("Replaced item"));
        String id = String.valueOf(item.getId());
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", id, replacedName, "1"}
        );
        List<UserAction> actions = Arrays.asList(
                new EditAction(output),
                new CloseAction(output)
        );
        new StartUI(output).init(in, memTracker,  actions);
        assertThat(memTracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        MemTracker memTracker = new MemTracker();
        Output output = new StubOutput();
        Item item = memTracker.add(new Item("Deleted item"));
        String id = String.valueOf(item.getId());
        Input in = new StubInput(
                new String[] {"0", id, "1"}
        );
        List<UserAction> actions = Arrays.asList(
                new DeleteItem(output),
                new CloseAction(output)
        );
        new StartUI(output).init(in, memTracker, actions);
        assertThat(memTracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        MemTracker memTracker = new MemTracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CloseAction(output));
        new StartUI(output).init(in, memTracker, actions);
        assertThat(output.toString(), is(
                "Menu:" + System.lineSeparator()
                        + "0. Exit program" + System.lineSeparator()
        ));
    }

    @Test
    public void whenReplaceItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item one = memTracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input in = new StubInput(
                new String[] {"0", String.valueOf(one.getId()), replaceName, "1"}
        );
        List<UserAction> actions = Arrays.asList(
                new EditAction(out),
                new CloseAction(out)
        );
        new StartUI(out).init(in, memTracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Edit item" + ln
                        + "1. Exit program" + ln
                        + "=== Edit item ===" + ln
                        + "Заявка заменена успешно." + ln
                        + "Menu:" + ln
                        + "0. Edit item" + ln
                        + "1. Exit program" + ln
        ));
    }

    @Test
    public void whenFindAllTestOutput() {
        Output output = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item one = memTracker.add(new Item(("test1")));
        Item two = memTracker.add(new Item(("test2")));
        Input in = new StubInput(
                new String[]{"0", "1"}
        );
        List<UserAction> actions = Arrays.asList(
                new ShowItems(output),
                new CloseAction(output)
        );
        new StartUI(output).init(in, memTracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString(), is(
                "Menu:" + ln
                        + "0. Show all items" + ln
                        + "1. Exit program" + ln
                        + "===Show all items===" + ln
                        + one + ln
                        + two + ln
                        + "Menu:" + ln
                        + "0. Show all items" + ln
                        + "1. Exit program" + ln
        ));
    }

    @Test
    public void whenFindByNameOutputTest() {
        Output output = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item one = memTracker.add(new Item("test1"));
        Input in = new StubInput(
                new String[]{"0", "test1", "1"}
        );
        List<UserAction> action = Arrays.asList(
                new FindItemByName(output),
                new CloseAction(output)
        );
        new StartUI(output).init(in, memTracker, action);
        String ln = System.lineSeparator();
        assertThat(output.toString(), is(
                "Menu:" + ln
                        + "0. Find items by name" + ln
                        + "1. Exit program" + ln
                        + "=== Find items by name ===" + ln
                        + one + ln
                        + "Menu:" + ln
                        + "0. Find items by name" + ln
                        + "1. Exit program" + ln
        ));
    }

    @Test
    public void whenFindByIdOutputTest() {
        Output output = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item one = memTracker.add(new Item("test1"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(one.getId()), "1"}
        );
        List<UserAction> action = Arrays.asList(
                new FindItemById(output),
                new CloseAction(output)
        );
        String ln = System.lineSeparator();
        new StartUI(output).init(in, memTracker, action);
        assertThat(output.toString(), is(
                "Menu:" + ln
                        + "0. Find item by id" + ln
                        + "1. Exit program" + ln
                        + "=== Find item by id ===" + ln
                        + one + ln
                        + "Menu:" + ln
                        + "0. Find item by id" + ln
                        + "1. Exit program" + ln
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"8", "0"}
        );
        MemTracker memTracker = new MemTracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CloseAction(out));
        new StartUI(out).init(in, memTracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                        "Menu:" + ln
                                + "0. Exit program" + ln
                                + "Wrong input, you can select: 0 .. 0" + ln
                                + "Menu:" + ln
                                + "0. Exit program" + ln
                )
        );
    }

}