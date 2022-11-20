package nerdle;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Statistics {
    //line 0: yarıda bırakılan oyunların sayısı
    //line 1: başarısız oyunların sayısı
    //line 2: başarılı oyunların sayısı
    //line 3: başarılmış ortalama satır
    //line 4: başarılmış ortalama süre
    //line 5-9: kaydedilmis oyun satirlari

    public Statistics(){

    }

    public boolean isThereSavedGame() throws IOException{
        Path path = Paths.get("stats.txt");
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        if(lines.get(5) != "0")
            return true;
        return false;
    }

    //returns specified line of statistics file
    public String getLine(int lineNumber) throws IOException {
        Path path = Paths.get("stats.txt");
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        return lines.get(lineNumber);
    }

    //returns previous inputs for continuing the game
    public String[] continueSavedGame() throws IOException {
        String[] returnAr = new String[5];
        Path path = Paths.get("stats.txt");
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        for(int i=5; i<10; i++)
            returnAr[i-5] = lines.get(i);
        return returnAr;
    }

    public String getSavedEquation() throws IOException {
        Path path = Paths.get("stats.txt");
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        return lines.get(10);
    }

    //deletes previous save
    public void deleteSavedGame() throws IOException {
        Path path = Paths.get("stats.txt");
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        for(int i=5; i<10; i++)
            lines.set(i,"0");
        Files.write(path, lines, StandardCharsets.UTF_8);
    }

    //takes array of inputs and saves the game to continue later
    public void saveGame(String[] eqs, String chosenEq) throws IOException {
        deleteSavedGame();
        for(int i=5; i<10; i++)
            setLine(i, eqs[i-5]);
        setLine(10, chosenEq);
    }

    //increasing the numbers of the games that is won,lost or quit by user
    public void setLine(int lineNumber) throws IOException {
        Path path = Paths.get("stats.txt");
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        lines.set(lineNumber, Integer.toString((Integer.parseInt(lines.get(lineNumber)) + 1)));
        Files.write(path, lines, StandardCharsets.UTF_8);
    }

    //calculates average line score
    public void setLine(int lineNumber, int numberOflines) throws IOException {
        Path path = Paths.get("stats.txt");
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        float newVal = (Float.parseFloat(lines.get(lineNumber)) + numberOflines) % (Float.parseFloat(lines.get(2)));
        lines.set(lineNumber, Float.toString(newVal));
        Files.write(path, lines, StandardCharsets.UTF_8);
    }

    //write inputs for saving
    public void setLine(int lineNumber, String newLine) throws IOException {
        Path path = Paths.get("stats.txt");
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        lines.set(lineNumber, newLine);
        Files.write(path, lines, StandardCharsets.UTF_8);
    }

    //creates file at the very beginning
    public File createFile() throws IOException {
        File file = new File("stats.txt");
        boolean value;
        {
            try {
                value = file.createNewFile();
                if(value)
                    System.out.println("the new file is created");
                else
                    System.out.println("file already exists");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileOutputStream fos = new FileOutputStream(file);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

        for (int i = 0; i < 10; i++) {
            bw.write("0");
            bw.newLine();
        }

        bw.close();

        return file;
    }

    //reading all the lines in stats.txt
    public String[] readLine() throws IOException {
        String[] statsAr = new String[5];
        int i=0;
        try{
            //the file to be opened for reading
            FileInputStream fis=new FileInputStream("stats.txt");
            Scanner sc=new Scanner(fis);    //file to be scanned
            //returns true if there is another line to read
            while(sc.hasNextLine()){
                statsAr[i] = sc.nextLine();
                //System.out.println(sc.nextLine());
                i++;//returns the line that was skipped
            }
            sc.close();     //closes the scanner
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return statsAr;
    }


}