package model.tag;

import java.util.List;
import model.mood.Mood;

public class TagAverages {
  public Mood GetTagCurrentAverage(String tag) {
    int angryAfraid = 0;
    int cheerfulDepressed = 0;
    int willfulYielding = 0;
    int pressuredLonely = 0;

    // запросы чтобы достать средние всех характеристик
    // как хранить тэги в бд?

    return new Mood(angryAfraid, cheerfulDepressed, willfulYielding, pressuredLonely);
  }
}
