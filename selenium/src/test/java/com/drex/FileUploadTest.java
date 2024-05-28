package com.drex;

import com.drex.pages.BasePage;
import com.drex.pages.FileUploadPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class FileUploadTest extends BaseTest {

    @Test(description = "Uploads a file")
    public void testFileUpload() {
        String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\share-folder.png";

        FileUploadPage fileUpload = new FileUploadPage();
        fileUpload.uploadFile(filePath);
        assertTrue(fileUpload.isUploadSuccess(), "Upload was not successful");
    }

}
