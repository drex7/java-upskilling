package specs;

import pages.FileDownloadPage;
import org.testng.annotations.Test;

public class FileDownloadTest extends BaseTest {

    @Test(description = "Downloads a file")
    public void testFileDownload() {
        FileDownloadPage fileDownload = new FileDownloadPage();
        fileDownload.navigateToPage().downloadPDF();
    }

    @Test(description = "Password Protected Download")
    public void testFileDownloadLocked() {
        FileDownloadPage fileDownload = new FileDownloadPage();
        fileDownload.navigateToPage().downloadLockedFile();
    }
}
