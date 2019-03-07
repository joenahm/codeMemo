package test;

import top.sjydzq.dao.CompanyDAO;
import top.sjydzq.javabean.Company;

import java.util.Vector;

public class Test {
    public static void main(String[] args) {
        CompanyDAO companyDAO = new CompanyDAO();

        Vector<Company> companies = companyDAO.query();

        for (Company company: companies) {
            System.out.println(company.getName());
        }
    }
}
