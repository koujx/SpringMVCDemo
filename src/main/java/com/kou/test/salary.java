package com.kou.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by KouJiaxing on 2017-8-10.
 */

public class salary {

    static class Rst {
        double salary;//月工资
        double salaryYear;//年终奖
        double monthLast;//月实际
        double yearLast;//年实际

        double taxMonth;//月个税
        double taxYear;//年个税
        double taxAll;//总税
        double last;//总收入

        public Rst(double salary, double salaryYear, double monthLast,
                   double yearLast, double taxMonth, double taxYear, double taxAll, double last) {
            this.salary = salary;
            this.salaryYear = salaryYear;
            this.monthLast = monthLast;
            this.yearLast = yearLast;
            this.taxMonth = taxMonth;
            this.taxYear = taxYear;
            this.taxAll = taxAll;
            this.last = last;
        }

        @Override
        public String toString() {
            return "月工资=" + salary +
                    ", 年终奖=" + salaryYear +
                    ", 每月结余=" + (salary - monthLast) +
                    ", 每月领取=" + monthLast +
                    ", 年终奖+结余=" + yearLast +
                    ", 月个税=" + taxMonth +
                    ", 年个税=" + taxYear +
                    ", 总税=" + taxAll +
                    ", 到手=" + last;
        }
    }

    public static List<Rst> list(double salary, double salaryYear) {
        List<Rst> list = new ArrayList<>();
        for (double i = salary; i > 0; i -= 100) {
            double monthLast = i;
            double yearLast = (salary - monthLast) * 12 + salaryYear;

            double taxMonth = getTaxMonth(i);
            double taxYear = getTaxYear(yearLast);
            double taxAll = taxMonth * 12 + taxYear;
            double last = salary * 12 + salaryYear - taxAll;

            Rst rst = new Rst(salary, salaryYear, monthLast, yearLast, taxMonth, taxYear, taxAll, last);
            list.add(rst);
        }

        Collections.sort(list, new Comparator<Rst>() {
            @Override
            public int compare(Rst o1, Rst o2) {
                return new Double(o1.taxAll).compareTo(o2.taxAll);
            }
        });
        return list;
    }


    public static double getTaxMonth(double salary) {
        double taxSalary = salary - 3500;
        double tax = taxSalary < 0 ? 0.0 :
                taxSalary <= 1500 ? 0.03 * taxSalary :
                        taxSalary <= 4500 ? taxSalary * 0.1 - 105 :
                                taxSalary <= 9000 ? taxSalary * 0.2 - 555 :
                                        taxSalary <= 35000 ? taxSalary * 0.25 - 1005 :
                                                taxSalary <= 55000 ? taxSalary * 0.3 - 2755 :
                                                        taxSalary <= 80000 ? taxSalary * 0.35 - 5505 :
                                                                taxSalary * 0.45 - 13505;
        return tax;
    }

    public static double getTaxYear(double salary) {
        double taxSalary = salary / 12;
        double tax = taxSalary < 0 ? 0.0 :
                taxSalary <= 1500 ? 0.03 * salary :
                        taxSalary <= 4500 ? salary * 0.1 - 105 :
                                taxSalary <= 9000 ? salary * 0.2 - 555 :
                                        taxSalary <= 35000 ? salary * 0.25 - 1005 :
                                                taxSalary <= 55000 ? salary * 0.3 - 2755 :
                                                        taxSalary <= 80000 ? salary * 0.35 - 5505 :
                                                                salary * 0.45 - 13505;
        return tax;
    }

    @Test
    public void salaryTest() {
        List<Rst> list = list(20000, 30000);
        System.out.println(list.get(0).toString());
        System.out.println(list.get(1).toString());
        System.out.println(list.get(2).toString());
        System.out.println(list.get(3).toString());
        System.out.println(list.get(4).toString());
    }
}
