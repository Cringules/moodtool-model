package model.interval;

import model.type.DayPeriod;
import model.type.YearPeriod;
import model.mood.Mood;

import java.util.List;


public class IntervalAverages {
  public Mood GetHourAverage(int hour) {
    if (hour < 0 || hour > 23) {
      throw new IllegalArgumentException("Incorrect hour!");
    }

    int angryAfraid = 0;
    int cheerfulDepressed = 0;
    int willfulYielding = 0;
    int pressuredLonely = 0;

    // запросы чтобы достать средние всех характеристик

    return new Mood(angryAfraid, cheerfulDepressed, willfulYielding, pressuredLonely);
  }

  public Mood GetDayPeriodAverage(int dayPeriod) {
    if (dayPeriod < 0 || dayPeriod > 3) {
      throw new IllegalArgumentException("Incorrect day period!");
    }

    int angryAfraid = 0;
    int cheerfulDepressed = 0;
    int willfulYielding = 0;
    int pressuredLonely = 0;

    int startHour = 0;
    int endHour = 0;

    switch (dayPeriod) {
      case 0 -> {startHour = 5; endHour = 12;}
      case 1 -> {startHour = 12; endHour = 18;}
      case 2 -> {startHour = 18; endHour = 23;}
      case 3 -> {startHour = 23; endHour = 5;}
    }

    // запросы чтобы достать среднее нужного окошка

    return new Mood(angryAfraid, cheerfulDepressed, willfulYielding, pressuredLonely);
  }

  public Mood GetWeekdayAverage(int weekday) {
    if (weekday < 0 || weekday > 6) {
      throw new IllegalArgumentException("Incorrect day period!");
    }

    int angryAfraid = 0;
    int cheerfulDepressed = 0;
    int willfulYielding = 0;
    int pressuredLonely = 0;

    // запросы чтобы достать среднее

    return new Mood(angryAfraid, cheerfulDepressed, willfulYielding, pressuredLonely);
  }

  public Mood GetMonthAverage(int month) {
    if (month < 0 || month > 11) {
      throw new IllegalArgumentException("Incorrect day period!");
    }

    int angryAfraid = 0;
    int cheerfulDepressed = 0;
    int willfulYielding = 0;
    int pressuredLonely = 0;

    // запросы чтобы достать средние всех характеристик

    return new Mood(angryAfraid, cheerfulDepressed, willfulYielding, pressuredLonely);
  }

  public Mood GetYearPeriodAverage(int yearPeriod, List<String> data) {
    if (yearPeriod < 0 || yearPeriod > 3) {
      throw new IllegalArgumentException("Incorrect day period!");
    }

    int angryAfraid = 0;
    int cheerfulDepressed = 0;
    int willfulYielding = 0;
    int pressuredLonely = 0;

    // под месяцы поменять да
    int startHour = 0;
    int endHour = 0;

    switch (yearPeriod) {
      case 0 -> {startHour = 5; endHour = 12;}
      case 1 -> {startHour = 12; endHour = 18;}
      case 2 -> {startHour = 18; endHour = 23;}
      case 3 -> {startHour = 23; endHour = 5;}
    }

    // запросы чтобы достать средние всех характеристик

    return new Mood(angryAfraid, cheerfulDepressed, willfulYielding, pressuredLonely);
  }
}
