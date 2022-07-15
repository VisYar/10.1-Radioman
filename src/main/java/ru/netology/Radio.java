package ru.netology;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Radio {
    private int currentStation;
    private int currentVolume;
    private int counterStation;
    private int minStation;
    private int maxStation = 10;
    private int minVolume;
    private int maxVolume = 100;

    public Radio(int countStation, int currentVolume) {
        this.counterStation = countStation;
        this.maxStation = countStation - 1;
        this.currentVolume = currentVolume;
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public int getMaxStation() {
        return maxStation;
    }

    public void setCurrentStation(int currentStation) {
        if (currentStation > maxStation) {
            return;
        }
        if (currentStation < minStation) {
            return;
        }
        this.currentStation = currentStation;
    }

    public void stationNext() {
        if (currentStation == maxStation) {
            this.currentStation = minStation;
            return;
        }
        currentStation = currentStation + 1;
    }

    public void stationPrev() {
        if (currentStation == minStation) {
            this.currentStation = maxStation;
            return;
        }
        currentStation = currentStation - 1;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int currentVolume) {
        this.currentVolume = currentVolume;
    }

    public void increaseVolume() {
        if (currentVolume < maxVolume) {
            currentVolume = currentVolume + 1;
        } else {
            this.currentVolume = maxVolume;
        }
    }

    public void decreaseVolume() {
        if (currentVolume > minVolume) {
            currentVolume = currentVolume - 1;
        } else {
            this.currentVolume = minVolume;
        }
    }
}
