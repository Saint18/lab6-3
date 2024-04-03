public class OrganizationDriver {
    public static void main(String[] args) {
        // Initialize the organization with a CEO
        OrganizationImpl CristoCorp = new OrganizationImpl("Gabriel Cristo", 100000.00, Gender.Male);
        
        // Add some employees and contract employees
        CristoCorp.addEmployee("Manager 1", 80000.00, Gender.Male, "Gabriel Cristo");
        CristoCorp.addEmployee("Employee 1", 50000.00, Gender.Male, "Manager 1");
        CristoCorp.addEmployee("Employee 2", 55000.00, Gender.Female, "Manager 2");
        
        // Assuming ContractEmployee has additional endDate parameters
        CristoCorp.addContractEmployee("Contract 1", 60000.00, Gender.Male, 31, 12, 2024, "CEO Name");
        
        // Add a sub-manager and some employees under them
        CristoCorp.addEmployee("Sub-Manager 1", 70000.00, Gender.Male, "Manager 1");
        CristoCorp.addEmployee("Sub-Employee 1", 45000.00, Gender.Male, "Sub-Manager 1");
        
        // Perform some operations
        System.out.println("Total number of employees in the organization: " + CristoCorp.getSize());
        System.out.println("Number of male employees in the organization: " + CristoCorp.getSizeByGender(Gender.Male));
        System.out.println("Number of female employees in the organization: " + CristoCorp.getSizeByGender(Gender.Female));
        
        // List all employees
        System.out.println("List of all employees:");
        for (String name : CristoCorp.allEmployees()) {
            System.out.println(name);
        }
    }
}
