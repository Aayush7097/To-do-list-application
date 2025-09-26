import java.util.ArrayList;
import java.util.Scanner;

public class ToDoListApp {

    private static ArrayList<String> tasks = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== TO-DO LIST MENU =====");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Edit Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addTask();
                case 2 -> viewTasks();
                case 3 -> editTask();
                case 4 -> deleteTask();
                case 5 -> System.out.println("Exiting... Goodbye!");
                default -> System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 5);
    }

    private static void addTask() {
        System.out.print("Enter new task: ");
        String task = sc.nextLine();
        tasks.add(task);
        System.out.println("Task added successfully!");
    }

    private static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            System.out.println("\nYour Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    private static void editTask() {
        viewTasks();
        if (tasks.isEmpty()) return;

        System.out.print("Enter task number to edit: ");
        int index = sc.nextInt();
        sc.nextLine(); // consume newline

        if (index > 0 && index <= tasks.size()) {
            System.out.print("Enter new task description: ");
            String newTask = sc.nextLine();
            tasks.set(index - 1, newTask);
            System.out.println("Task updated successfully!");
        } else {
            System.out.println("Invalid task number!");
        }
    }

    private static void deleteTask() {
        viewTasks();
        if (tasks.isEmpty()) return;

        System.out.print("Enter task number to delete: ");
        int index = sc.nextInt();
        sc.nextLine(); // consume newline

        if (index > 0 && index <= tasks.size()) {
            tasks.remove(index - 1);
            System.out.println("Task deleted successfully!");
        } else {
            System.out.println("Invalid task number!");
        }
    }
}

