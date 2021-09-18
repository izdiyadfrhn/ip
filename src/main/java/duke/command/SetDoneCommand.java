package duke.command;

import duke.Ui;
import duke.TaskList;
import duke.exceptions.DukeException;

public class SetDoneCommand extends Command {

    private int chosenTaskIndex;

    /**
     * Marks a task with given index as done
     * @param ui UI to be used
     * @param taskList TaskList to be used
     * @param chosenTaskIndex index of task to be marked as done
     */
    public SetDoneCommand(Ui ui, TaskList taskList, int chosenTaskIndex) {
        super(ui, taskList);
        this.chosenTaskIndex = chosenTaskIndex;
    }

    /**
     * Executes SetDoneCommand
     * @throws DukeException
     */
    @Override
    public void execute() throws DukeException {

        if (chosenTaskIndex < 0 || chosenTaskIndex > tasks.size()) {
            throw new DukeException("Index is not within range!");
        } else {
            tasks.setTaskDone(chosenTaskIndex);
            ui.printWithLines("set as done: " + tasks.get(chosenTaskIndex).toString());
        }
    }
}
