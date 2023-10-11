package FileGeneratingForTesting;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class TextFileGenerationCode {
	    public static void main(String[] args) {
	        // Specify the file path and name
	        String filePath = "D:\\Mayur\\1gb_file.txt"; // Updated file path

	        // Specify the target file size in bytes (1 GB)
	        long targetFileSizeInBytes = 1024L * 1024L * 1024L;

	        // Use a larger buffer size to reduce IO operations
	        int bufferSize = 1024 * 1024; // 1 MB buffer size

	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath), bufferSize)) {
	            // Create a sample line of text with the desired length
	            StringBuilder line = new StringBuilder();
	            while (line.length() < bufferSize) {
	                line.append("This is some sample text. ");
	            }

	            // Repeat the line to reach the target file size
	            long bytesWritten = 0;
	            while (bytesWritten < targetFileSizeInBytes) {
	                writer.write(line.toString());
	                bytesWritten += bufferSize;
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        System.out.println("Text file of approximately 1 GB created successfully at: " + filePath);
	    }

}
