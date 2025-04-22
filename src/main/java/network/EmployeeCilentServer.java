package network;

import daos.dao_impl.AllDaoImpl;
import daos.dao_interface.AllDao;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.rmi.registry.LocateRegistry;

public class EmployeeCilentServer {
    public static void main(String[] args) throws Exception{
        AllDao allDao = new AllDaoImpl();
        Context ct = new InitialContext();
        LocateRegistry.createRegistry(1099);
        ct.bind("rmi://localhost:1099/AllDao", allDao);
        System.out.println("Server is running...");

    }
}
