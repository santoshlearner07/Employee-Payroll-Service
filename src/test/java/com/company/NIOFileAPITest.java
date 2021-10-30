package com.company;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchService;
import java.util.stream.IntStream;

public class NIOFileAPITest {
    private static String HOME = System.getProperty("user.home");
    private static String PLAY_WITH_NIO = "TempPlayGround";

    @Test
    public void givenPathWhenCheckedThenConfirm() throws IOException {

        Path homePath = Paths.get(HOME);
        Assert.assertTrue(Files.exists(homePath));

//        Delete File and check file not exist
        Path playPath = Paths.get(HOME + "/" + PLAY_WITH_NIO);
        if (Files.exists(playPath)) FileUtils.deleteFiles(playPath.toFile());
        Assert.assertTrue(Files.notExists(playPath));

//        Create Directory
        Files.createDirectory(playPath);
        Assert.assertTrue(Files.exists(playPath));

//Create File
        IntStream.range(1, 10).forEach(cntr -> {
            Path tempFIle = Paths.get(playPath + "/temp" + cntr);
            Assert.assertTrue(Files.notExists(tempFIle));
            try {
                Files.createFile(tempFIle);
            } catch (IOException e) {
            }
            Assert.assertTrue(Files.exists(tempFIle));
        });

//        List Files, Directories with extension
        Files.list(playPath).filter(Files::isRegularFile).forEach(System.out::println);
        Files.newDirectoryStream(playPath).forEach(System.out::println);
        Files.newDirectoryStream(playPath, path -> path.toFile().isFile() &&
                path.toString().startsWith("temp")).forEach(System.out::println);
    }

//    @Test
//    public void givenADirectoryWhenWatchedListAllTheActivities() throws IOException {
//        Path dir = Paths.get(HOME + "/" + PLAY_WITH_NIO);
//        Files.list(dir).filter(Files::isRegularFile).forEach(System.out::println);
//        new Java8WatchService(dir, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY).processEvents();
//    }

    @Test
    public void givenDirectory_WhenWatched_ShouldReturnAllActivities() throws IOException
    {
        Path dir = Paths.get(HOME+'/'+PLAY_WITH_NIO);
        Files.list(dir).filter(Files::isRegularFile).forEach(System.out::println);
        new Java8WatchService(dir).processEvents();
    }
}
