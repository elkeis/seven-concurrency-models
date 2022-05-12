/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package ThreadsAndLocks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class App {
    private Map<String, ITask> tasks = new HashMap<String, ITask>();

    private Options options = new Options();
    private HelpFormatter helpFormatter = new HelpFormatter();

    private App() {
        this.tasks.put("HelloWorld", new HelloWorld());

        this.options.addOption("t", "task", true, "Enter name of task you want to run: " + tasks.keySet().toString());
        this.options.addOption("h", "help", false, "Help message.");
    }

    private void printHelp() {
        this.helpFormatter.printHelp("app", this.options);
    }

    public void run(String taskName) {
        ITask task = tasks.get(taskName);
        if (task != null) {
            task.run();
        } else {
            System.out.println("No such task as " + taskName);
            System.out.println("Available tasks: " + tasks.keySet().toString());
        }
    }

    public static void main(String[] args) {
        try {
            App app = new App();
            CommandLineParser parser = new DefaultParser();
            CommandLine cmd = parser.parse(app.options, args);
            List<Option> options = Arrays.asList(cmd.getOptions());
            if (options.size() == 0) {
                app.printHelp();
            } else {
                options.forEach(option -> {
                    switch (option.getOpt()) {
                        case "t":
                            app.run(option.getValue());
                            break;
                        case "h":
                            app.printHelp();
                            break;
                        default:
                            app.printHelp();
                    }
                });
            }
        } catch (ParseException ex) {
            System.out.println(ex);
        }
    }
}