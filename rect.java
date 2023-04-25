import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
// import Rectangle;



public class rect {
    
    public static void main(String[] args) {
        
        ArrayList<Rectangle> MainList = new ArrayList<Rectangle>();
        String directory = "csv";
        File dir = new File(directory);
        if (!dir.exists()) {
            System.err.println("Directory not found: " + directory);
            return;
        }

        File[] files = dir.listFiles((dir1, name) -> name.matches("rectangles_\\d+\\.csv"));
        if (files == null || files.length == 0) {
            System.err.println("No CSV files found.");
            return;
        }
        int i=0;
        for (File file : files) {
            
            System.out.println("Reading file: " + file.getName());
            MainList.clear();
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                boolean firstLine = true; // flag to ignore first line
                while ((line = br.readLine()) != null) {
                    if (firstLine) {
                        firstLine = false;
                        continue;
                    }
                    String[] values = line.split(",");
                    int numRectangles = Integer.parseInt(values[0].trim());
                    int rectangleNumber = Integer.parseInt(values[1].trim());
                    int xb = Integer.parseInt(values[2].trim());
                    int yb = Integer.parseInt(values[3].trim());
                    int xt = Integer.parseInt(values[4].trim());
                    int yt = Integer.parseInt(values[5].trim());
                    System.out.printf("Processing rectangle %d of %d rectangles: (%d,%d) to (%d,%d)%n", rectangleNumber, numRectangles, xb, yb, xt, yt);
                    // Perform additional processing on the rectangle data here
                    Rectangle temp = new Rectangle(xb, yb, xt, yt);
                    MainList.add(temp);
                    // System.out.println("the current bottom x is" + temp.xb);
                    // Rectangle temp = new Rectangle(xb, yb, xt, yt)
                    // currentarray
                }        
            } catch (IOException e) {
                System.err.println("Error reading file: " + file.getName());
                e.printStackTrace();
            }
            i+=1;
            for(int q =0;q<MainList.size();q++){
                // System.out.println("hello");
                Rectangle temp = MainList.get(q);
                //System.out.println("it works"+temp.xb);
                temp.check(MainList, q);
                // temp.printRectangles();
                for(int j =0;j<temp.rectArray.size();j++){
                    System.out.println("xb is :"+temp.rectArray.get(j).xb+"yb is :"+temp.rectArray.get(j).yb+"xt is :"+temp.rectArray.get(j).xt+"yt is :"+temp.rectArray.get(j).yt);
                }
                
               }
               
        }
        
        System.out.println(i);
    }


}

