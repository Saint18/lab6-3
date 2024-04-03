import java.util.ArrayList;
import java.util.List;

public class OrganizationImpl implements Organization {
    private GroupNode<Employee> boss; // the top-level node. top supervisor. ceo

    public OrganizationImpl(String name, double pay, Gender gender) {
        this.boss = new GroupNode<>(new Supervisor(name, pay, gender));
    }

    @Override
    public void addEmployee(String name, double pay, Gender gender, String supervisorName) {
        Employee newEmployee = new NonManagerEmployee(name, pay, gender);
        addEmployeeUnderSupervisor(boss, newEmployee, supervisorName);
    }

    @Override
    public void addContractEmployee(String name, double pay, Gender gender, int endDate, int endMonth, int endYear, String supervisorName) {
        Employee newContractEmployee = new ContractEmployee(name, pay, gender, endDate, endMonth, endYear);
        addEmployeeUnderSupervisor(boss, newContractEmployee, supervisorName);
    }

    private void addEmployeeUnderSupervisor(GroupNode<Employee> supervisorNode, Employee employee, String supervisorName) {
        if (supervisorNode.getData().getName().equals(supervisorName)) {
            supervisorNode.addChild(new LeafNode<>(employee));
        } else {
            for (TreeNode<Employee> child : supervisorNode.getChildren()) {
                if (child instanceof GroupNode) {
                    addEmployeeUnderSupervisor((GroupNode<Employee>) child, employee, supervisorName);
                }
            }
        }
    }

    @Override
    public int getSize() {
        return boss.toList().size();
    }

    @Override
    public int getSizeByGender(Gender gender) {
        return (int) boss.toList().stream().filter(e -> e.getGender() == gender).count();
    }

    @Override
    public List<String> allEmployees() {
        List<String> names = new ArrayList<>();
        for (Employee e : boss.toList()) {
            names.add(e.getName());
        }
        return names;
    }
}
