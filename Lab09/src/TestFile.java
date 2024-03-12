import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class TestFile {
        public static void main(String[] args) {
        TestFile testFile = new TestFile();
        HashMap<String, int[]> allScores = testFile.read_scores("student_scores.csv");
        System.out.println("All Scores:");
        for (String studentID : allScores.keySet()) {
            System.out.println(studentID + " - " + Arrays.toString(allScores.get(studentID)));
        }

        String studentIDToLookup = "6632462421";
        int totalScore = testFile.getTotalScore(allScores, studentIDToLookup);
        if (totalScore != -1) {
            System.out.println("Total Score for " + studentIDToLookup + ": " + totalScore);
        } else {
            System.out.println("Student not found.");
        }

        HashSet<String> editedStudentIDs = testFile.getEditedStudentID("edited_scores.csv");
        System.out.println("Edited Student IDs: " + editedStudentIDs);

        testFile.createNewEditedScore("student_scores.csv", "edited_scores.csv", "new_scores.csv");
        System.out.println("New scores have been written to 'new_scores.csv'.");
    }
    
    public HashMap<String, int[]> read_scores(String filePath) {
        HashMap<String, int[]> scores = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine(); 
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String studentId = parts[0];
                int[] scoreArray = Arrays.stream(parts, 1, parts.length)
                                         .mapToInt(Integer::parseInt)
                                         .toArray();
                scores.put(studentId, scoreArray);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return scores;
    }

    public int getTotalScore(HashMap<String, int[]> scores, String studentId) {
        if (!scores.containsKey(studentId)) {
            return -1; 
        }
        return Arrays.stream(scores.get(studentId)).sum();
    }

    public HashSet<String> getEditedStudentID(String filePath) {
        HashSet<String> editedStudentIDs = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine(); 
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                editedStudentIDs.add(parts[0]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return editedStudentIDs;
    }

    public void createNewEditedScore(String originalFilePath, String editedFilePath, String newFilePath) {
        HashMap<String, int[]> originalScores = read_scores(originalFilePath);
        try (BufferedReader reader = new BufferedReader(new FileReader(editedFilePath))) {
            String line;
            reader.readLine(); 
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String studentId = parts[0];
                int quizIndex = Integer.parseInt(parts[1].replace("Quiz", "")) - 1;
                int newScore = Integer.parseInt(parts[2]);

                int[] scores = originalScores.get(studentId);
                if (scores != null && quizIndex >= 0 && quizIndex < scores.length) {
                    scores[quizIndex] = newScore; 
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (PrintWriter writer = new PrintWriter(new File(newFilePath))) {
            writer.println("ID,Quiz1,Quiz2,Quiz3,Quiz4,Quiz5");
            for (Map.Entry<String, int[]> entry : originalScores.entrySet()) {
                String studentId = entry.getKey();
                int[] scores = entry.getValue();
                String joinedScores = Arrays.stream(scores)
                                            .mapToObj(String::valueOf)
                                            .collect(Collectors.joining(","));
                writer.println(studentId + "," + joinedScores);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}