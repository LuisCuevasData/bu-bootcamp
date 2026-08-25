import java.io.*;
import java.util.ArrayList;

public class GradeAnalyzer {

    public static void main(String[] args) {
        // "Want to Go Further?": Use command-line arguments if provided, otherwise default to "scores.txt"
        String filename = (args.length > 0) ? args[0] : "scores.txt";
        
        // Step 1: read scores from file
        ArrayList<Integer> scores = readScores(filename);

        // Step 2: calculate statistics
        double avg = calculateAverage(scores);

        // Step 5: Find the Highest and Lowest Scores directly in main
        int high = Integer.MIN_VALUE;
        int low = Integer.MAX_VALUE;

        // Loop through the list to find the min and max
        if (!scores.isEmpty()) {
            for (int score : scores) {
                if (score > high) {
                    high = score;
                }
                if (score < low) {
                    low = score;
                }
            }
        } else {
            // Failsafe in case the file was completely empty
            high = 0;
            low = 0;
        }

        // Step 3: write and print report
        writeReport(scores, avg, high, low, "report.txt");
    }

    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename) {
        ArrayList<Integer> scores = new ArrayList<>();

        // Step 3: Implement readScores using BufferedReader
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            
            // Loop to read the file line by line
            while ((line = reader.readLine()) != null) {
                line = line.trim(); // Remove whitespace

                if (line.isEmpty()) {
                    continue; // Skip blank lines
                }

                try {
                    // Try to parse the integer
                    int score = Integer.parseInt(line);
                    scores.add(score);
                } catch (NumberFormatException e) {
                    // Print warning and skip invalid lines
                    System.out.println("Warning: Invalid line skipped -> " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error: Could not read file -> " + e.getMessage());
        }

        return scores;
    }

    // Returns the average of a list of scores, or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> scores) {
        // Step 4: Implement calculateAverage
        if (scores == null || scores.isEmpty()) {
            return 0.0;
        }

        double total = 0.0;
        for (int score : scores) {
            total += score;
        }

        return total / scores.size();
    }

    // Writes and prints the report
    public static void writeReport(ArrayList<Integer> scores, double avg, int high, int low, String outputFile) {
        // Step 6: Count the Grade Bands
        int countA = 0, countB = 0, countC = 0, countD = 0, countF = 0;

        for (int score : scores) {
            if (score >= 90) {
                countA++;
            } else if (score >= 80) {
                countB++;
            } else if (score >= 70) {
                countC++;
            } else if (score >= 60) {
                countD++;
            } else {
                countF++;
            }
        }

        // Step 7: Implement writeReport using BufferedWriter
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            
            // Using a StringBuilder to format the report neatly so we can both write and print it
            StringBuilder report = new StringBuilder();
            report.append("=== Grade Analysis Report ===\n");
            report.append(String.format("Total scores processed: %d\n\n", scores.size()));

            report.append(String.format("Average score: %.2f\n", avg));
            report.append(String.format("Highest score: %d\n", high));
            report.append(String.format("Lowest score:  %d\n\n", low));

            report.append("Grade distribution:\n");
            report.append(String.format("  A (90-100):   %d\n", countA));
            report.append(String.format("  B (80-89):    %d\n", countB));
            report.append(String.format("  C (70-79):    %d\n", countC));
            report.append(String.format("  D (60-69):    %d\n", countD));
            report.append(String.format("  F (below 60): %d\n", countF));

            String finalReport = report.toString();

            // Write the formatted string to report.txt
            writer.write(finalReport);

            // Print the exact same formatted string to the terminal
            System.out.println("\n" + finalReport);

        } catch (IOException e) {
            System.out.println("Error writing report: " + e.getMessage());
        }
    }
}