package org.aston.lesson_8;

import java.util.*;

public class PhoneBook {
    private final Map<String, List<String>> mapPhones = new HashMap<>();

    public void addPhoneToBook(String lastName, String phone){
        if(this.mapPhones.containsKey(lastName)){
            this.mapPhones.get(lastName).add(phone);
        } else {
            this.mapPhones.put(lastName, new ArrayList<>(Collections.singletonList(phone)));
        }
    }

    public List<String> getPhoneByLastName(String lastName){
        return this.mapPhones.containsKey(lastName) ? this.mapPhones.get(lastName)
                                                    : new ArrayList<>();
    }
}
