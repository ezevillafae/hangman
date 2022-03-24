package ar.edu.ungs.hangman.apps;

import ar.edu.ungs.hangman.apps.cli.CliApplication;
import ar.edu.ungs.hangman.apps.forms.FormsApplication;
import ar.edu.ungs.hangman.apps.shared.Application;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public final class Starter {
    private final static Map<String, Class<? extends Application>> applications = applications();

    public static void main(String[] args) {
        ensureApplicationExists(args);

        String applicationName = args[0];

        run(applicationName);
    }

    private static void run(String applicationName) {
        try {
            applications.get(applicationName).getConstructor().newInstance().run();
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException error){
            throw new RuntimeException(String.format("can not run <%s> application", applicationName));
        }
    }

    private static void ensureApplicationExists(String[] args) {
        if (args[0] == null || args[0].isEmpty()) {
            throw new RuntimeException("the application not selected");
        }

        if (!applications.containsKey(args[0])) {
            throw new RuntimeException(String.format("the application <%s> not exists", args[0]));
        }
    }

    private static HashMap<String, Class<? extends Application>> applications() {
        return new HashMap<String, Class<? extends Application>>() {{
            put("cli", CliApplication.class);
            put("forms", FormsApplication.class);
        }};
    }
}
