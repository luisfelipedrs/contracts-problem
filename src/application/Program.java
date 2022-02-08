package application;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Program {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter department's name: ");
        Department department = new Department(sc.nextLine());

        System.out.println("Enter worker data:");

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Level: ");
        WorkerLevel level = WorkerLevel.valueOf(sc.nextLine());

        System.out.print("Base salary: ");
        double salary = sc.nextDouble();

        System.out.print("How many contracts to this worker? ");
        int n = sc.nextInt();

        Worker worker = new Worker(name, level, salary, department);

        for (int i = 0; i < n; i++) {
            System.out.println("Enter contract #" + (i + 1) + ": ");

            System.out.print("Date (DD/MM/YYYY): ");
            Date date = sdf.parse(sc.next());

            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();

            System.out.print("Duration (hours): ");
            int hours = sc.nextInt();

            worker.addContract(new HourContract(date, valuePerHour, hours));

            sc.nextLine();
        }

        System.out.println();
        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        String date = sc.nextLine();
        System.out.println(date);

        int year = Integer.parseInt(date.substring(3));
        int month = Integer.parseInt(date.substring(0, 2));

        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());
        System.out.println("Income for " + date + ": " + String.format("%.2f", worker.income(year, month)));

        sc.close();
    }
}
