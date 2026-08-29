import java.util.Scanner;

    public class StudentGrades {

        public static double calculateAverage(int[] scores) {
            if (scores == null) {
                throw new IllegalArgumentException("Scores array cannot be null.");
            }
            if (scores.length == 0) {
                throw new IllegalArgumentException("Scores array cannot be empty.");
            }
            int sum = 0;
            for (int score : scores) {
                if (score < 0) {
                    throw new IllegalArgumentException("Score cannot be less than 0.");
                }
                if (score > 100) {
                    throw new IllegalArgumentException("Score cannot be greater than 100.");
                }
                sum += score;
            }
            double average = (double) sum / scores.length;

            if (average < 40) {
                throw new FailedSignificantlyException("Student average is " + average + ", which is a significant failure.");
            }

            return average;
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.print("Enter scores (comma-separated): ");
                String input = scanner.nextLine();

                String[] parts = input.split(",");
                int[] scores = new int[parts.length];
                for (int i = 0; i < parts.length; i++) {
                    scores[i] = Integer.parseInt(parts[i].trim());
                }

                double average = calculateAverage(scores);
                System.out.println("Average score: " + average);

            } catch (NumberFormatException e) {
                System.out.println("Invalid input: Please enter a valid number for scores. " + e.getMessage());
            } catch (FailedSignificantlyException e) {
                System.out.println("Significant Failure: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } finally {
                scanner.close();
                System.out.println("Grade calculation process concluded.");
            }
        }
    }

