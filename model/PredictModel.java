package ru.cringules.moodtool.backend.model;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import ru.cringules.moodtool.backend.data.MoodEntry;

public class PredictModel {

  public Mood PredictMood(Instant curDate, List<String> tags) {
    double timeAngryAfraid = 0;
    double timeCheerfulDepressed = 0;
    double timeWillfulYielding = 0;
    double timePressuredLonely = 0;

    Timestamp date = Timestamp.from(curDate);

    // !!!!
    IntervalAverages intervalAverages = new IntervalAverages(moodEntryRepository);

    int dayPeriod = 3;
    if (date.getHours() > 4 && date.getHours() < 12) {
      dayPeriod = 0;
    } else if (date.getHours() > 11 && date.getHours() < 18) {
      dayPeriod = 1;
    } else if (date.getHours() > 17 && date.getHours() < 23) {
      dayPeriod = 2;
    }

    List<Mood> timeAverages = new ArrayList<Mood>(Arrays.asList(
        intervalAverages.GetHourAverage(date.getHours()),
        intervalAverages.GetDayPeriodAverage(dayPeriod),
        intervalAverages.GetWeekdayAverage(date.getDay()),
        intervalAverages.GetMonthAverage(date.getMonth())));

    for (Mood mood : timeAverages) {
      timeAngryAfraid += mood.angryAfraid();
      timeCheerfulDepressed += mood.cheerfulDepressed();
      timeWillfulYielding += mood.willfulYielding();
      timePressuredLonely += mood.pressuredLonely();
    }

    timeAngryAfraid /= 4;
    timeCheerfulDepressed /= 4;
    timeWillfulYielding /= 4;
    timePressuredLonely /= 4;

    if (tags.isEmpty()) {
      return new Mood((int) timeAngryAfraid, (int) timeCheerfulDepressed, (int) timeWillfulYielding, (int) timePressuredLonely);
    }

    int tagAngryAfraid = 0;
    int tagCheerfulDepressed = 0;
    int tagWillfulYielding = 0;
    int tagPressuredLonely = 0;

    // !!!!
    TagAverages tagAverages = new TagAverages(moodEntryRepository);

    List<MoodEntry> mood = moodEntryRepository.findAll();
    int n = tags.size();

    for (String tag : tags) {
      if (mood.stream().filter(m -> m.getTags().contains(tag)).toList().isEmpty()) {
        n -= 1;
        continue;
      }
      Mood curMood = tagAverages.GetTagCurrentAverage(tag);
      tagAngryAfraid += curMood.angryAfraid();
      tagCheerfulDepressed += curMood.cheerfulDepressed();
      tagWillfulYielding += curMood.willfulYielding();
      tagPressuredLonely += curMood.pressuredLonely();
    }

    if (n < 1) {
      return new Mood((int) timeAngryAfraid, (int) timeCheerfulDepressed, (int) timeWillfulYielding, (int) timePressuredLonely);
    }

    tagAngryAfraid /= n;
    tagCheerfulDepressed /= n;
    tagWillfulYielding /= n;
    tagPressuredLonely /= n;

    return new Mood((int) (timeAngryAfraid + tagAngryAfraid) / 2,
        (int) (timeCheerfulDepressed + tagCheerfulDepressed) / 2,
        (int) (timeWillfulYielding + tagWillfulYielding) / 2,
        (int) (timePressuredLonely + tagPressuredLonely) / 2);
  }
}
