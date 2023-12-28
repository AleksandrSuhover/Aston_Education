package org.aston.lesson_4;

import java.util.ArrayList;
import java.util.List;

public class Park {
    private String parkName;
    private String parkAddress;
    private List<Attraction> attractions = new ArrayList<>();

    public Park(String parkName, String parkAddress){
        this.parkName = parkName;
        this.parkAddress = parkAddress;
    }

    public void addAttraction(Attraction attraction){
        this.attractions.add(attraction);
    }

    @Override
    public String toString() {
        return "Park{" +
                "parkName='" + parkName + '\'' +
                ", parkAddress='" + parkAddress + '\'' +
                ", attractions=" + attractions +
                '}';
    }

    public class Attraction{
        private String attractionName;
        private String openingHours;
        private Double price;

        public Attraction(String attractionName, String openingHours, Double price) {
            this.attractionName = attractionName;
            this.openingHours = openingHours;
            this.price = price;
        }

        @Override
        public String toString() {
            return "Attraction{" +
                    "attractionName='" + attractionName + '\'' +
                    ", openingHours='" + openingHours + '\'' +
                    ", price=" + price +
                    '}';
        }
    }

}
