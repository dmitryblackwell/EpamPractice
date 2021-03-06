package ua.nure.veretelnyk.web.command;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class CommandContainer {
    private static final Logger LOG = Logger.getLogger(CommandContainer.class);

    private static Map<String, Command> commands = new HashMap<>();

    static {
        commands.put("login", new LoginCmd());
        commands.put("register", new RegistrCmd());
        commands.put("logout", new LogoutCmd());

        commands.put("error", new ErrorCmd());

        commands.put("ticket_search", new TicketSearchCmd());
        commands.put("get_page", new GetPageCmd());
        commands.put("settings_pane", new SettingsCmd());
        commands.put("buy_ticket", new BuyTicketCmd());
        commands.put("route_add", new RouteAddCmd());
        commands.put("station_add", new StationAddCmd());
        commands.put("station_delete", new StationDeleteCmd());
        commands.put("route_delete", new RouteDeleteCmd());

        LOG.debug("CommandContainer initialized.");
    }

    public static Command get(String commandName){
        if (commandName == null || !commands.containsKey(commandName))
            commandName = "error";

        return commands.get(commandName);
    }
}
