package cashdesk.service;

import cashdesk.model.dao.DaoFactory;
import org.apache.log4j.Logger;


public class UsersService {
    private static final Logger LOG = Logger.getLogger(UsersService.class);

    DaoFactory daoFactory = DaoFactory.getInstance();
}
