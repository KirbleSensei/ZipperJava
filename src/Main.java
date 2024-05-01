import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

public class Main {

    //commit
    private static final String BELOW = "below ~~~~~~~~~~~~~~~~~ V";
    private static final String ABOVE = "above ~~~~~~~~~~~~~~~~~ A";
    private static final String[] allowedFiles = {"Node"};

    private static List<String> getCodeBlocks(String filename) throws IOException {
        BufferedReader student_reader = new BufferedReader(new FileReader(filename));
        StringBuilder student_block = new StringBuilder();
        boolean insideCodeBlock = false;
        String new_line;
        List<String> code_lines = new java.util.ArrayList<>(List.of());
        while ((new_line = student_reader.readLine()) != null) {
            if (insideCodeBlock) {
                if (new_line.contains(ABOVE)) {
                    insideCodeBlock = false;
                    code_lines.add(student_block.toString());
                    student_block.setLength(0);
                } else {
                    student_block.append(new_line).append("\n");
                }
            } else if (new_line.contains(BELOW)) {
                insideCodeBlock = true;
            }
        }
        return code_lines;
    }


    public static void main(String[] args) throws Exception {

        String rootDir = System.getProperty("user.dir");

        String server_source = rootDir + File.separator + "ServerSrc";
        String student_source = rootDir + File.separator + "StudentSrc";

        String template_file;

        File[] student_files = new File(student_source).listFiles();

        for (File studentFile : student_files) {
                for (String to_be_submitted : allowedFiles) {
                    if (studentFile.getName().equals(to_be_submitted + ".java")) {
                        template_file = rootDir + File.separator + "TeacherSrc" + File.separator + getFileName(String.valueOf(studentFile)) + ".java";
                        Path after = Merge(String.valueOf(studentFile), template_file, server_source);
                        // Testing phase
                        Files.deleteIfExists(after);
                    }
                }
        }
    }

    private static String getFileName(String filepath) {
        if (filepath.substring(filepath.lastIndexOf(File.separator)).contains(".")) {
            return filepath.substring(filepath.lastIndexOf(File.separator) + 1, filepath.lastIndexOf("."));
        } else {
            return filepath.substring(filepath.lastIndexOf(File.separator) + 1);
        }

    }


    private static Path Merge(String student_file, String solution_file, String outputPath) throws IOException {

        String student_file_name = getFileName(student_file);

        File merged_file = new File(outputPath + File.separator + student_file_name + ".java");

        try (BufferedReader templateReader = new BufferedReader(new FileReader(solution_file)); FileWriter writer = new FileWriter(merged_file)) {
            // Read the template file and write its content to the output file
            String line;
            while ((line = templateReader.readLine()) != null) {
                if (line.contains("class")) {
                    String class_name = getFileName(student_file);
                    line = "public class " + class_name + " {";
                }
                writer.write(line);
                writer.write("\n");
            }
            writer.write("\n"); // Add a newline after the template content
            writer.flush();
            writer.close();


            List<String> lines = Files.readAllLines(Path.of(merged_file.getPath()), StandardCharsets.UTF_8);
            List<String> code_lines = getCodeBlocks(student_file);
            int index = 0;
            for (int i = 0; i < lines.size(); i++) {
                if (lines.get(i).contains(BELOW)) {
                    i++; // Skip line
                    if (code_lines.isEmpty()) {
                        Files.write(Path.of(merged_file.getPath()), Collections.singleton("invalid submission"), StandardCharsets.UTF_8);
                        break;
                    }
                    lines.set(i, code_lines.get(index));
                    Files.write(Path.of(merged_file.getPath()), lines, StandardCharsets.UTF_8);
                    index++;
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return merged_file.toPath();
    }
}
