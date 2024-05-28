package com.drex;

import com.drex.pages.BasePage;
import com.drex.pages.FileUploadPage;
import org.testng.annotations.Test;

public class FileUploadTest extends BaseTest {

    @Test(description = "Uploads a file")
    public void testFileUpload() {
        FileUploadPage fileUpload = new FileUploadPage();
        fileUpload.uploadFile("//resources/share-folder.png");
    }

}
