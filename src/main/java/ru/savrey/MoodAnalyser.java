package ru.savrey;

public class MoodAnalyser {
    public String analyseMood(String message) {
        if (message.toLowerCase().contains("плох")) return "Bad Mood";
        if (message.toLowerCase().contains("хорош")) return "Good Mood";
        return "Normal Mood";
    }
}
