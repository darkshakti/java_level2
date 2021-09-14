package ru.geekbrains.lesson7.hw.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Temperature {
    @JsonProperty("Minimum")
    private Minimum minimum;

    @JsonProperty("Maximum")
    private Maximum maximum;

    public Temperature() {
    }

    public Temperature(Minimum minimum, Maximum maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }

    public Minimum getMinimum() {
        return minimum;
    }

    public void setMinimum(Minimum minimum) {
        this.minimum = minimum;
    }

    public Maximum getMaximum() {
        return maximum;
    }

    public void setMaximum(Maximum max) {
        this.maximum = max;
    }

    @Override
    public String toString() {
        return "Temperature{" +
                "minimum=" + minimum +
                ", max=" + maximum +
                '}';
    }
}

