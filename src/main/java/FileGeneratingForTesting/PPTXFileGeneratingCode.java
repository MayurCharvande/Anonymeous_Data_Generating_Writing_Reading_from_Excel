	package FileGeneratingForTesting;

	import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFTextBox;
import org.apache.poi.xslf.usermodel.XSLFTextParagraph;
import org.apache.poi.xslf.usermodel.XSLFTextRun;

	public class PPTXFileGeneratingCode {
	    public static void main(String[] args) {
	        // Specify the file path and name
	        String filePath = "D:\\Mayur\\1gb file\\1gb_test_large_presentation.pptx";

	        // Specify the target file size in bytes (1 GB)
	        long targetFileSizeInBytes = 1024L * 1024L * 1024L;

	        try (XMLSlideShow ppt = new XMLSlideShow()) {
	            long currentFileSize = 0;

	            while (currentFileSize < targetFileSizeInBytes) {
	                // Create a new slide
	                XSLFSlide slide = ppt.createSlide();

	                // Add text content to the slide
	                XSLFTextBox textBox = slide.createTextBox();
	                XSLFTextParagraph paragraph = textBox.addNewTextParagraph();
	                XSLFTextRun textRun = paragraph.addNewTextRun();
	                textRun.setText("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor...");

	                // Estimate the current file size based on added slides
	                currentFileSize = estimateFileSize(ppt);

	                // If the estimated file size reaches or exceeds the target size, break the loop
	                if (currentFileSize >= targetFileSizeInBytes) {
	                    break;
	                }
	            }

	            // Save the PowerPoint presentation
	            try (FileOutputStream out = new FileOutputStream(filePath)) {
	                ppt.write(out);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        System.out.println("PPTX file created successfully at: " + filePath);
	    }

	    private static long estimateFileSize(XMLSlideShow ppt) {
	        // This method estimates the file size based on the number of slides
	        // and other factors such as formatting, which may not be entirely accurate
	        // but provides a rough estimate of the current file size.
	        long estimatedSize = 0;

	        // Approximate size of an empty slide
	        long emptySlideSize = 1000; // Adjust this value as needed

	        int numberOfSlides = ppt.getSlides().size();

	        // Estimate based on the number of slides
	        estimatedSize = emptySlideSize * numberOfSlides;

	        return estimatedSize;
	    }
	}




