package com.drex;

import com.drex.pages.FileDownloadPage;
import org.testng.annotations.Test;

public class FileDownloadTest extends BaseTest {
    @Test(description = "Downloads a file")
    public void testFileDownload() {
        FileDownloadPage fileDownload = new FileDownloadPage();
        fileDownload.downloadPDF();
    }
}
