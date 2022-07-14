package ru.netology;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RadioTest {
    Radio station = new Radio(10);

    @Test
    public void stationEntered() {
        int maxStation = 9;
        int actual = station.getMaxStation();
        int expected = maxStation;
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/stationNext.csv")

    public void numberNext(String name, int currentStation, int expected) {
        station.setCurrentStation(currentStation);
        station.stationNext();
        int actual = station.getCurrentStation();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/stationPrev.csv")

    public void numberPrev(String name, int currentStation, int expected) {
        station.setCurrentStation(currentStation);
        station.stationPrev();
        int actual = station.getCurrentStation();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/increaseVolume.csv")
    public void increaseVolumeStation(String name, int currentVolume, int expected) {
        station.setCurrentVolume(currentVolume);
        station.increaseVolume();
        int actual = station.getCurrentVolume();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/decreaseVolume.csv")

    public void decreaseVolumeStation(String name, int currentVolume, int expected) {
        station.setCurrentVolume(currentVolume);
        station.decreaseVolume();
        int actual = station.getCurrentVolume();
        assertEquals(expected, actual);
    }
}
