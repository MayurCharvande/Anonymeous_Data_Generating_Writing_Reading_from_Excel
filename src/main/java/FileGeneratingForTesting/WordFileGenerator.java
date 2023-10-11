package FileGeneratingForTesting;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
public class WordFileGenerator {
	public static void main(String[] args) {
        String filePath = "D:\\Mayur\\Test_large.docx"; // Updated file path
        long targetFileSizeInBytes = 1024L * 1024L * 1024L; // 1 GB

        try {
            // Create a new Word document
         XWPFDocument document = new XWPFDocument();

            // Create a paragraph style with centered alignment
  //          XWPFParagraphStyle centeredStyle = document.createParagraph().getParagraphAlignment().getCTP().addNewPPr().addNewJc();
 //           centeredStyle.setVal(STJc.CENTER);
            
            // Create a paragraph style with centered alignment
            XWPFParagraph paragraph = document.createParagraph();
            paragraph.setAlignment(ParagraphAlignment.CENTER);

            // Create a range for the document
      //      XWPFParagraph paragraph = document.createParagraph();
    //        paragraph.setStyle(centeredStyle);

            // Add content to the document until it reaches the target size
            StringBuilder text = new StringBuilder();
            while (text.length() < targetFileSizeInBytes) {
                text.append("Lorem ipsum dolor sit amet, consectetur adipiscing elit. ");
            }

            paragraph.createRun().setText(text.toString());

            // Save the document
            FileOutputStream out = new FileOutputStream(filePath);
            document.write(out);
            out.close();

            System.out.println(".docx file of approximately 1 GB created successfully at: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
