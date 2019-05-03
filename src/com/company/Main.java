package com.company;


import com.company.model.Account;
import com.company.model.GenderEnum;

import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Long nowTime = System.currentTimeMillis();
        String uid = "1";
        String nickName = "炸鸡小子";
        GenderEnum gender = GenderEnum.男;
        Integer age = 25;
        String userName = "zhajixiaozi";
        String password = "123456";
        String address = "上海市虹口区";
        String mobile = "17635696658";
        Timestamp createdOn = new Timestamp(nowTime);

        String uid2 = "2";
        String nickName2 = "炸鸡小子2";
        GenderEnum gender2 = GenderEnum.男;
        Integer age2 = 22;
        String userName2 = "zhajixiaozi2";
        String password2 = "123456";
        String address2 = "上海市虹口区";
        String mobile2 = "17635696658";
        Timestamp createdOn2 = new Timestamp(nowTime);

        String uid3 = "3";
        String nickName3 = "炸鸡小子3";
        GenderEnum gender3 = GenderEnum.女;
        Integer age3 = 23;
        String userName3 = "zhajixiaozi3";
        String password3 = "123456";
        String address3 = "上海市";
        String mobile3 = "17635696658";
        Timestamp createdOn3 = new Timestamp(nowTime);

        Account account1 = new Account(uid, nickName, gender, age, userName, password, mobile, address, createdOn);
        Account account2 = new Account(uid2, nickName2, gender2, age2, userName2, password2, mobile2, address2, createdOn2);
        Account account3 = new Account(uid3, nickName3, gender3, age3, userName3, password3, mobile3, address3, createdOn3);
        List<Account> bunchOfAccounts = Arrays.asList(new Account[]{account3, account1, account2});

        // filter 1
        List<Account> uidEquals1List = bunchOfAccounts.stream()
                .filter(account -> account != null && "1".equals(account.getUid()))
                .collect(Collectors.toList());
        uidEquals1List.forEach(account -> System.out.println(account.getNickName()));

        // filter 2
        List<Account> uidEquals2List = bunchOfAccounts.stream()
                .filter(account -> {
                    if (account != null) {
                        if ("炸鸡小子3".equals(account.getNickName())) {
                            return true;
                        }
                    }
                    return false;
                })
                .collect(Collectors.toList());
        uidEquals2List.forEach(account -> System.out.println(account.getNickName()));

        // sort 1
        List<Account> uidSorted1List = bunchOfAccounts.stream()
                .sorted(Comparator.comparing(Account::getUid))
                .collect(Collectors.toList());
        uidSorted1List.forEach(account -> System.out.println(account.getUid()));

        // sort 2
        List<Account> uidSorted2List = bunchOfAccounts.stream()
                .sorted(Comparator.comparing(Account::getUid).reversed())
                .collect(Collectors.toList());
        uidSorted2List.forEach(account -> System.out.println(account.getUid()));

        // map 1
        List<String> account2UidList = bunchOfAccounts.stream()
                .map(account -> account.getUid())
                .collect(Collectors.toList());
        account2UidList.forEach(System.out::println);

        // page
        int pageIndex = 0;
        int pageSize = 10;
        List<Account> pageOfAccount = bunchOfAccounts.stream()
                .skip(pageIndex * pageSize)
                .limit(pageSize)
                .collect(Collectors.toList());
        pageOfAccount.forEach(account -> System.out.println(account.getUid()));

        // sql: select count(*) from account where mobile like '176%' group by age;
        // group by
        Map<Integer, List<Account>> GroupByOfAccountCount = bunchOfAccounts.stream()
                .filter(account -> account != null && account.getMobile().startsWith("176"))
                .collect(Collectors.groupingBy(Account::getAge));
        GroupByOfAccountCount.keySet().forEach(key -> System.out.println(GroupByOfAccountCount.get(key).size()));
    }
}
