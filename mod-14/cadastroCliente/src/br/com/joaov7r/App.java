package br.com.joaov7r;

import br.com.joaov7r.dao.ClientMapDAO;
import br.com.joaov7r.dao.IClientDAO;
import br.com.joaov7r.domain.Client;

import javax.swing.*;

public class App {

    private static IClientDAO iClienteDAO;

    public static void main(String[] args) {
        iClienteDAO = new ClientMapDAO();

        String option = JOptionPane.showInputDialog(null,
                "Type 1 to Register, 2 to Consult, 3 to Delete, 4 to Update or 5 to Exit",
                "Client Register", JOptionPane.INFORMATION_MESSAGE);

        while (!isValidOption(option)) {
            if ("".equals(option)) {
                exit();
            }
            option = JOptionPane.showInputDialog(null,
                    "Invalid option! Type 1 to Register, 2 to Consult, 3 to Delete, 4 to Update or 5 to Exit",
                    "Client Register", JOptionPane.INFORMATION_MESSAGE);
        }

        while (isValidOption(option)) {
            if (isExitOption(option)) {
                exit();
            } else if (isRegister(option)) {
                String data = JOptionPane.showInputDialog(null,
                        "Type the client data separated by comma, as in the example: Name, CPF, Phone, Address, Number, City e State",
                        "Register", JOptionPane.INFORMATION_MESSAGE);
                register(data);
            } else if (isConsult(option)){
                String data = JOptionPane.showInputDialog(null,
                        "Type the client's CPF",
                        "Consult", JOptionPane.INFORMATION_MESSAGE);
                consult(data);
            } else if (isDelete(option)){
                String data = JOptionPane.showInputDialog(null,
                        "Type the client's CPF",
                        "Delete", JOptionPane.INFORMATION_MESSAGE);
                delete(data);
            } else {
                String data = JOptionPane.showInputDialog(null,
                        "Type the client data separated by comma, as in the example: Name, CPF, Phone, Address, Number, City e State",
                        "Update", JOptionPane.INFORMATION_MESSAGE);
                update(data);
            }
            option = JOptionPane.showInputDialog(null,
                    "Type 1 to Register, 2 to Consult, 3 to Delete, 4 to Update or 5 to Exit",
                    "Client Register", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void update(String data) {
        String[] separatedData = data.split(",");
        Client client = new Client(separatedData[0], Long.parseLong(separatedData[1]), Long.parseLong(separatedData[2]), separatedData[3], Integer.parseInt(separatedData[4]), separatedData[5], separatedData[6]);
        iClienteDAO.update(client);
    }

    private static boolean isUpdate(String option) {
        if ("4".equals(option)){
            return true;
        }
        return false;
    }

    private static void delete(String data) {
        Client client = iClienteDAO.consult(Long.parseLong(data));
        if (client != null) {
            JOptionPane.showMessageDialog(null, "Client deleted successfully: " + client.toString(), "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Client not found", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static boolean isDelete(String option) {
        if ("3".equals(option)){
            return true;
        }
        return false;
    }

    private static void consult(String data) {
        Client client = iClienteDAO.consult(Long.parseLong(data));
        if (client != null) {
            JOptionPane.showMessageDialog(null, "Client found successfully: " + client.toString(), "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Client not found", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static boolean isConsult(String option) {
        if ("2".equals(option)){
            return true;
        }
        return false;
    }

    private static void register(String data) {
        String[] separatedData = data.split(",");
        Client client = new Client(separatedData[0], Long.parseLong(separatedData[1]), Long.parseLong(separatedData[2]), separatedData[3], Integer.parseInt(separatedData[4]), separatedData[5], separatedData[6]);
        Boolean isRegistered = iClienteDAO.register(client);
        if (isRegistered) {
            JOptionPane.showMessageDialog(null, "Client registered successfully", "Success",JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Client already registered", "Error",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static boolean isRegister(String option) {
        if ("1".equals(option)){
            return true;
        }
        return false;
    }

    private static boolean isExitOption(String option) {
        if ("5".equals(option)){
            return true;
        }
        return false;
    }

    private static void exit() {
        JOptionPane.showMessageDialog(null,"See you!","Exit", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    private static boolean isValidOption(String option) {
        if ("1".equals(option) || "2".equals(option)
                || "3".equals(option) || "4".equals(option) || "5".equals(option)) {
            return true;
        }
        return false;
    }

    private static boolean isOptionRegister(String option) {
        if ("1".equals(option)){
            return true;
        }
        return false;
    }
}
