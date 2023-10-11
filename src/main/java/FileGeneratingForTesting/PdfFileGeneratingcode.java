import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.PDType1Font;

public class PdfFileGeneratingcode {

    public static void main(String[] args) {
        // Specify the file path and name with .pdf extension
        String filePath = "D:\\Mayur\\1gb_file.pdf"; // Updated file path

        // Specify the target file size in bytes (1 GB)
        long targetFileSizeInBytes = 1024L * 1024L * 1024L;

        try {
            // Create a new PDF document
            PDDocument document = new PDDocument();

            // Create a page with a large size to increase file size
            PDPage page = new PDPage(PDRectangle.A0); // A0 is a large page size
            document.addPage(page);

            // Create a content stream to add text
            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            
            // Create a sample text
            StringBuilder text = new StringBuilder();
            while (text.length() < targetFileSizeInBytes) {
                text.append("Hello, World! ");
            }

            // Add text to the page using a built-in font (e.g., HELVETICA_BOLD)
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12); // Use a built-in font
            contentStream.beginText();
            contentStream.newLineAtOffset(100, 700);
            contentStream.showText(text.toString());
            contentStream.endText();
            contentStream.close();

            // Save the PDF document
            document.save(filePath);
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("PDF file of approximately 1 GB created successfully at: " + filePath);
    }
}
