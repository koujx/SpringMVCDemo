package com.kou.test;

import java.text.ParseException;
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

    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, ParseException {

//        UserEntity userEntity = new UserEntity();
//        userEntity.setId(1);
//        userEntity.setFirstName("asdsa");
//        userEntity.setLastName("asdadaxw");
//        userEntity.setNickname("sadsaxa");
//
//        String user = JSON.toJSONString(userEntity);
//        JSONObject jsonObject = JSONObject.parseObject(user);
        List<Integer> list = null;

        System.out.println(list.size());
        for (Integer integer :list) {
           System.out.println(integer);
        }




//        List<Long> longs = Lists.newArrayList(1L, 2L, 3L);
//        Long[] aa = longs.toArray(new Long[longs.size()]);
//        System.out.println(longs.toString());
//
//        Long aLong = 20170809000000L;
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
//        Date date = simpleDateFormat.parse(aLong.toString());
//        LocalDate localDate1 = LocalDate.fromDateFields(date);
//        LocalDate localDate2 = localDate1.plusDays(10);
//        String lll = localDate2.toString().replace("-", "");
//        System.out.println(lll);
//
//
//        LocalDate localDate = LocalDate.parse("2017-08-09");
//        System.out.println(localDate);
//
//        int a = 1000;
//        int b = 500;
//        System.out.println(a);
//        a = (a < b) ? a : b;
//        System.out.println(a);
//
//        Map<String, Object> paramters = Maps.newHashMap();
//        paramters.put("agentUcid", 1000000020388392L);
//        paramters.put("displaySwitch", 1);
//        paramters.put("cityId", 110000);
//        System.out.println(paramters.toString().substring(1,paramters.toString().length()-1).replace(", ", "&"));

//        LocalDate today = LocalDate.now();
//        System.out.println(today);
//        System.out.println(today.getYear());
//        System.out.println(today.getMonthOfYear());
//        System.out.println(today.getDayOfMonth());
//        System.out.println(today.getDayOfWeek());
//        System.out.println(today.getDayOfYear());
//
//        LocalDate date = LocalDate.parse("2017-02-28");
//        System.out.println(date);
//        System.out.println(date.getYear());
//        System.out.println(date.getMonthOfYear());
//        System.out.println(date.getDayOfMonth());
//        System.out.println(date.getDayOfWeek());
//        System.out.println(date.getDayOfYear());
//
//        LocalDate today = LocalDate.now();
//        LocalDate dateTime = LocalDate.parse("2016-12-30");
//        if (dateTime.isAfter(today)) {
//            System.out.println(111);
//        } else {
//            System.out.println(222);
//        }
//
//        Instant instant = Instant.now();
//        System.out.println(instant);
//
//        LocalDateTime localDateTime = LocalDateTime.now();
//        System.out.println(localDateTime);
//        LocalDateTime date = localDateTime.minusMillis(1000);
//        System.out.println(date);
//        if (localDateTime.isAfter(date)) {
//            System.out.println(333);
//        }
//
//
//        MonthDay birtyday = MonthDay.parse("1992-8-21");
//        MonthDay current = MonthDay.now();
//        if (current.equals(birtyday)) {
//            System.out.println("happy birthday");
//        }
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//        Date endTime = simpleDateFormat.parse(LocalDate.now() + " 03:00:00");
//        Date startTime = simpleDateFormat.parse(LocalDate.now().minusDays(1) + " 03:00:00");
//        System.out.println(startTime);
//        System.out.println(endTime);
//
//        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyyMMddhhmmss");
//        Long l =20170821000000L;
//        Date date1 = simpleDateFormat1.parse(l.toString());
//        System.out.println(date1);
//        if (endTime.before(date1)) {
//            System.out.println("before");
//        }else {
//            System.out.println("after");
//        }
//
//        Map<Long, Object> map = Maps.newHashMap();
//        map.put(100001L,"aaa");
//        map.put(100002L,"bbb");
//        map.put(100003L,"ccc");
//        map.put(100004L,"ddd");
//        Set<Long> set = map.keySet();
//        List<Long> list = Lists.newArrayList(set);
//
//        System.out.println(map);
//        System.out.println(set);
//        System.out.println(list);

    }


}
