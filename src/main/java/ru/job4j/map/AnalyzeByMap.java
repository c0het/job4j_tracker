package ru.job4j.map;

import java.util.*;


public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        int numbersOfPoints = 0;
        double rsl = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                rsl += subject.getScore();
                numbersOfPoints++;
            }
        }
        rsl = rsl / numbersOfPoints;
        return rsl;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        double score = 0D;
        int numberOfClasses = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                score += subject.getScore();
                numberOfClasses++;
            }
            rsl.add(new Label(pupil.name(), score / numberOfClasses));
            score = 0D;
            numberOfClasses = 0;
        }
        return rsl;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        LinkedHashMap<String, Double> scoreBySub = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                scoreBySub.computeIfPresent(subject.getName(), (k, v) -> v + subject.getScore());
                scoreBySub.putIfAbsent(subject.getName(), subject.getScore());

            }
        }
        for (String key : scoreBySub.keySet() ) {
            rsl.add(new Label(key, scoreBySub.get(key) / pupils.size()));
        }
        return rsl;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        int bestScore = 0;
        String nameOfBestStudent = averageScoreByPupil(pupils).stream()
                .sorted(Label::compareTo)
                .toList().get(0).name();
        for (Pupil pupil : pupils) {
            if (nameOfBestStudent.equals(pupil.name())) {
                for (Subject subject : pupil.subjects()) {
                    bestScore += subject.getScore();
                }
            }
        }
        return new Label(nameOfBestStudent, bestScore);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        int bestScore = 0;
        String nameOfBestSubject = averageScoreBySubject(pupils).stream()
                .sorted(Label::compareTo)
                .toList().get(0).name();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                if (nameOfBestSubject.equals(subject.getName())) {
                    bestScore += subject.getScore();
                }
            }
        }
        return new Label(nameOfBestSubject, bestScore);
    }
}