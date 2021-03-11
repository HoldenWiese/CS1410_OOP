package a5;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;

class FileUtilsTest {

	@Test
	void testFindFile() {
		File test1 = new File("src");
		File test2 = null;

		assertEquals(null, FileUtils.findFile("test", test2), "Test failed with input " + test2);
		assertEquals("latest-file.txt", FileUtils.findFile("latest-file.txt", test1).getName(),
				"Test failed: FileUtils.findFile(\"latest-file.txt\", test1).getName()");
		assertEquals("cities.txt", FileUtils.findFile("cities.txt", test1).getName(),
				"Test failed: FileUtils.findFile(\"cities.txt\", test1).getName()");
		assertEquals("FileUtils.java", FileUtils.findFile("FileUtils.java", test1).getName(),
				"Test failed: FileUtils.findFile(\"FileUtils.java\", test1).getName()");
		assertEquals("single-file.txt", FileUtils.findFile("single-file.txt", test1).getName(),
				"Test failed: FileUtils.findFile(\"single-file.txt\", test1).getName()");
	}

	@Test
	void testFindLatestFile() {
		File test1 = null;
		File test2 = new File("src/a5/sampledir");
		File test3 = new File("src/a5/sampledir/dir-of-dirs/one-file-subdir");
		File test4 = new File("src/a5/sampledir/dir-of-dirs/two-files-subdir");

		assertEquals(null, FileUtils.findLatestFile(test1), "Test failed with input: " + test1);
		assertEquals("latest-file.txt", FileUtils.findLatestFile(test2).getName(), "Test failed with input: " + test2);
		assertEquals("single-file.txt", FileUtils.findLatestFile(test3).getName(), "Test failed with input: " + test3);
		assertEquals("file-1-of-2.txt", FileUtils.findLatestFile(test4).getName(), "Test failed with input: " + test4);
	}

}
