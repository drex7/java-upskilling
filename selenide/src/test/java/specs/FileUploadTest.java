package specs;

import pages.FileUploadPage;
import org.testng.annotations.Test;
import specs.BaseTest;

import java.io.File;

import static org.testng.Assert.assertTrue;

public class FileUploadTest extends BaseTest {

    @Test(description = "Uploads a file")
    public void testFileUpload() {
//        String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\share-folder.png";
        String filePath = "src/main/resources/groovy.png";
        File file = new File("src/main/resources/groovy.png");
        FileUploadPage fileUpload = new FileUploadPage();
        fileUpload
                .navigateToPage()
                .uploadFile(filePath);
        fileUpload.assertUploadSuccess("Thank you for your message. It has been sent.");
//        assertTrue(fileUpload.isUploadSuccess(), "Upload was not successful");
    }

}
