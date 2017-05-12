package com.kou.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by KouJiaxing on 2017-4-18.
 */
public class test {


   /* public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        System.out.println(list.size());
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println(list.size());
        for (int e : list) {
            int index = list.indexOf(e);
            System.out.println(index);
        }
        list.add(5, 15);
        for (int i:list) {
            System.out.println(i+"-----"+list.indexOf(i));
        }
    }*/


    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
        List<Company> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Company company = new Company();
            company.setId((int) (i*100*Math.random()));
            company.setName((long) (i*100*Math.random()));
            company.setSuccess(i*100*Math.random());
            list.add(company);
        }
        System.out.println("排序前");

        List<Company> result = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            Company company = list.get(i);
            boolean insertFlag = false;
            for (int j = 0; j < result.size(); j++) {
                Company pointCompany = result.get(j);
                if (SortUtils.sortObjectByParam(company,pointCompany,"id")){
                    result.add(j,company);
                    insertFlag = true;
                }
            }
            if (!insertFlag){
                result.add(company);
            }
        }
        System.out.println("排序后");
    }
}
