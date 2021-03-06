package ua.nure.veretelnyk.web.command;

import org.apache.log4j.Logger;
import ua.nure.veretelnyk.Message;
import ua.nure.veretelnyk.Path;
import ua.nure.veretelnyk.db.DBManager;
import ua.nure.veretelnyk.exception.AppException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StationAddCmd extends Command {

    private static final Logger LOG = Logger.getLogger(StationAddCmd.class);

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws  AppException {
        String name = req.getParameter("name-of-station");
        String country = req.getParameter("country");

        LOG.debug("Add new station " + name + " in " + country);

        if (name == null || country == null || name.isEmpty() || country.isEmpty())
            throw new AppException(Message.WRONG_INPUT);

        DBManager db = DBManager.getInstance();

        if (!db.addStation(name, Integer.parseInt(country)))
            return Path.PAGE_ERROR;

        LOG.debug("Station added");
        return Path.PAGE_ADMIN;
    }
}
