import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");
        boolean correct = true;
        File dir = new File("C://dir");
            if (dir.mkdir()){
                File dirGame = new File("C://dir/Game");
                if(dirGame.mkdir()){  //Если будет папка dir а папки Game не будет, то код повалится
                    System.out.println("good");
                }
            }
        //1
        File dirSrc = new File("C://dir/Game/src");
        File dirRes = new File("C://dir/Game/res");
        File dirSaveGames = new File("C://dir/Game/savegames");
        File dirTemp = new File("C://dir/Game/temp");
        if (dirSrc.mkdir() && dirRes.mkdir() && dirSaveGames.mkdir() && dirTemp.mkdir()){
            System.out.println("Directories in dirGames were created");
        } else {
            correct = false;
        }
        //2
        File dirMain = new File(dirSrc, "main");
        File dirTest = new File(dirSrc, "test");
        if (dirMain.mkdir() && dirTest.mkdir()){
            System.out.println("Directories in dirSrc were created");
        } else {
            correct = false;
        }
        //3
        File main = new File(dirMain, "Main.java");
        File utils = new File(dirMain, "Utils.java");
        if (main.createNewFile() && utils.createNewFile()){
            System.out.println("New files Main.java and Utils.java were created successfully");
        } else {
            correct = false;
        }
        //4
        File dirDrawables = new File(dirRes, "drawables");
        File dirVectors = new File(dirRes, "vectors");
        File dirIcons = new File(dirRes, "icons");
        if (dirDrawables.mkdir() && dirVectors.mkdir() && dirIcons.mkdir()){
            System.out.println("Directories in dirRes were created");
        } else {
            correct = false;
        }
        //5
        File temp = new File(dirTemp, "temp.txt");
        if (temp.createNewFile()){
            System.out.println("New file temp.txt was created successfully");
        } else {
            correct = false;
        }
        //6
        try (FileOutputStream fos = new FileOutputStream(temp)){
            String success = "информации об успешноном создании файлов и директорий.";
            String notSuccess = "информации об неуспешном создании файлов и директорий.";
            //даже если файл открыт пользователем, ява перезапишет
            if (correct) {
                fos.write(success.getBytes());
            } else {
                fos.write(notSuccess.getBytes());
            }
        } catch (FileNotFoundException e) {
            //Вот тут мы никак и ничего не запишем в файл temp
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }




    }
}