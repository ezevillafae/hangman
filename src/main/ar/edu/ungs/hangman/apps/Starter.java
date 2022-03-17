package ar.edu.ungs.hangman.apps;

import ar.edu.ungs.hangman.apps.cli.CliApplication;
import ar.edu.ungs.hangman.apps.forms.FormsApplication;
import ar.edu.ungs.hangman.apps.shared.Application;

import java.util.HashMap;
import java.util.Map;

public final class Starter {
    private final static Map<String, Application> applications = applications();

    public static void main(String[] args) {
        ensureApplicationExists(args);

        String applicationName = args[0];

        applications.get(applicationName).run();
    }

    private static void ensureApplicationExists(String[] args) {
        if (args[0] == null || args[0].isEmpty()){
            throw new RuntimeException("the application not selected");
        }

        if (!applications.containsKey(args[0])){
            throw new RuntimeException(String.format("the application <%s> not exists", args[0]));
        }
    }

    private static HashMap<String, Application> applications() {
        return new HashMap<String, Application>() {{
            put("cli", new CliApplication());
            put("forms", new FormsApplication());
        }};
    }
}
